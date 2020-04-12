package com.sy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.OrderMapper;
import com.sy.pojo.OrderAddress;
import com.sy.pojo.OrderItem;
import com.sy.pojo.vo.OrderBookVO;
import com.sy.pojo.vo.OrderInfoVO;
import com.sy.pojo.vo.OrderVO;
import com.sy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/getOrderTable")
    public String getOrderTable(@RequestParam("limit") Integer limit,
                                @RequestParam("page") Integer page,
                                @RequestParam("orderStatus") Integer orderStatus,
                                @RequestParam(name = "orderId", defaultValue = "") String orderId,
                                @RequestParam(name = "createTime", defaultValue = "") String createTime) {
        System.out.println(orderId + "  " + createTime);
        List<OrderVO> orderVOList = new ArrayList<>();
        if (orderId.equals("") && createTime.equals("")) {
//            System.out.println(0);
            orderVOList = orderMapper.getOrderByStatus((page - 1) * limit, limit, orderStatus);
        } else if (!orderId.equals("") && createTime.equals("")) {
//            System.out.println(1);
            orderVOList = orderMapper.searchOrderByOrderId((page - 1) * limit, limit, orderStatus, orderId);
        } else if (!createTime.equals("") && orderId.equals("")) {
//            System.out.println(2);
            orderVOList = orderMapper.searchOrderByCreateTime((page - 1) * limit, limit, orderStatus, createTime + "%");
        } else if (!createTime.equals("") && !orderId.equals("")) {
//            System.out.println(3);
            orderVOList = orderMapper.searchOrder((page - 1) * limit, limit, orderStatus, orderId, createTime + "%");
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        //count主要用于计算总页数， 要区别对待 搜索这一特殊情况  担心每次都like会影响效率，所以设置两个方法来做
        jsonObject.put("count", orderVOList.size());
        jsonObject.put("data", orderVOList);
        return JSON.toJSONString(jsonObject);
    }

    @RequestMapping("/toOrderInfo")
    public String toOrderInfo(@RequestParam("orderId") String orderId,
                              @RequestParam("currentStatus") Integer currentStatus,
                              Model model) {
        OrderInfoVO order = orderMapper.getOrderByOrderId(orderId);
        OrderAddress orderAddress = orderMapper.getOrderAddressByOrderId(orderId);
        List<OrderItem> orderItems = orderMapper.getOrderItemsByOrderId(orderId);
        List<OrderBookVO> orderBookVOList = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderBookVO orderBookVO = bookInfoMapper.getOrderBookVOByBookId(orderItem.getBookId());
            orderBookVO.setBuyNumber(orderItem.getBuyNumber());
            orderBookVOList.add(orderBookVO);
        }
        model.addAttribute("order", order);
        model.addAttribute("orderAddress", orderAddress);
        model.addAttribute("orderBookVOList", orderBookVOList);
        model.addAttribute("currentStatus", currentStatus);
        return "page/order-info";
    }

    // 0 待发货 1 已发货  2 已完成 3 已退款
    @ResponseBody
    @PostMapping("/toChangeOrderStatus")
    public Integer toChangeOrderStatus(
            @RequestParam("orderStatus") Integer orderStatus,
            @RequestParam("orderId") String orderId) {
        if (orderStatus != 3)
            return orderMapper.changeOrderStatus(orderStatus, orderId);
        Integer result = 1;
        try {
            orderService.orderRefund(orderId);
        } catch (Exception e) {
            result = 0;
            e.printStackTrace();
        } finally {
            return result;
        }
    }


    @ResponseBody
    @PostMapping("/multipleChangeStatus")
    public Integer multipleChangeStatus(
            @RequestParam("orderStatus") Integer orderStatus,
            @RequestParam("orderIdList") String orderIdList) {
        List<String> list = JSON.parseArray(orderIdList, String.class);
        Integer i = orderMapper.multipleChangeStatus(orderStatus, list);
        //返回的是 行改变数量，只要大于零 就是操作成功了
        return i > 0 ? 1 : 0;
    }


    //退货   退款
}

