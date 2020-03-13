package com.sy.controller;

import com.sy.mapper.UserMapper;
import com.sy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;


@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/getAll")
    public List<User> getUser() {

        List<User> list = userMapper.getAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        return list;
    }


    @PostMapping("/userLogin")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPassword") String userPassword,
                        Model model) {
        User user = userMapper.getUserByUsername(userName);
        String msg;
        if (user == null) {
            msg = "用户不存在";
            model.addAttribute("msg", msg);
            return "page/login";
        } else if (user.getUserPassword().equals(userPassword)) {
            msg = "";
            model.addAttribute("msg", msg);
            model.addAttribute("user", user);
            return "index";
        } else {
            msg = "密码错误";
            model.addAttribute("msg", msg);
            return "page/login";

        }
    }


    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("userImg") MultipartFile userImg,
                                 @RequestParam("userEmail") String userEmail,
                                 @RequestParam("userId") String userId,
                                 @RequestParam("img") String img,
                                 RedirectAttributes redirectAttributes) throws Exception {
        String userImgName = img;
        if (!userImg.isEmpty()) {
            //获得图片后缀
            String extUserImg = userImg.getOriginalFilename().substring(userImg.getOriginalFilename().lastIndexOf("."));
            //生成唯一名称
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + extUserImg;
            //资源images 文件夹目录
            String filePath = System.getProperty("user.dir").toString() + "\\src\\main\\resources\\static\\images\\userImg\\";
            FileCopyUtils.copy(userImg.getInputStream(), new FileOutputStream(new File(filePath + fileName)));
            userImgName = "/images/userImg/" + fileName;
        }
        userMapper.updateUserInfo(Long.parseLong(userId), userEmail, userImgName);
        redirectAttributes.addAttribute("userId", userId);

        return "redirect:/userInfo";
    }


}
