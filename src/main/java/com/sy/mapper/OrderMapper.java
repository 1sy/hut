package com.sy.mapper;

import com.sy.pojo.OrderAddress;
import com.sy.pojo.OrderItem;
import com.sy.pojo.dto.OrderRefundDTO;
import com.sy.pojo.vo.OrderIndexVO;
import com.sy.pojo.vo.OrderInfoVO;
import com.sy.pojo.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    Integer addOrder(@Param("orderId") String orderId, @Param("userId") Long userId, @Param("orderAmount") BigDecimal orderAmount, @Param("orderStatus") Integer orderStatus);


    Integer addOrderItem(@Param("orderId") String orderId, @Param("bookId") String bookId, @Param("buyNumber") Integer buyNumber);

    Integer addOrderAddress(@Param("orderId") String orderId, @Param("addresseeName") String addresseeName, @Param("addresseeTelephone") String addresseeTelephone, @Param("addresseeAddress") String addresseeAddress);

    List<OrderVO> getOrderByStatus(@Param("page") Integer page, @Param("limit") Integer limit, @Param("orderStatus") Integer orderStatus);

    Integer getCountByStatus(@Param("orderStatus") Integer orderStatus);


    OrderInfoVO getOrderByOrderId(@Param("orderId") String orderId);

    OrderRefundDTO getOrderRefundByOrderId(@Param("orderId") String orderId);

    OrderAddress getOrderAddressByOrderId(@Param("orderId") String orderId);

    List<OrderItem> getOrderItemsByOrderId(@Param("orderId") String orderId);

    Integer changeOrderStatus(@Param("orderStatus") Integer orderStatus, @Param("orderId") String orderId);

    List<OrderVO> searchOrder(@Param("page") Integer page, @Param("limit") Integer limit, @Param("orderStatus") Integer orderStatus, @Param("orderId") String orderId, @Param("createTime") String createTime);

    List<OrderVO> searchOrderByCreateTime(@Param("page") Integer page, @Param("limit") Integer limit, @Param("orderStatus") Integer orderStatus, @Param("createTime") String createTime);

    List<OrderVO> searchOrderByOrderId(@Param("page") Integer page, @Param("limit") Integer limit, @Param("orderStatus") Integer orderStatus, @Param("orderId") String orderId);

    Integer multipleChangeStatus(@Param("orderStatus") Integer orderStatus, @Param("orderIdList") List<String> orderIdList);

    Integer getTotalCount();

    List<OrderIndexVO> getRecentOrder();
}


