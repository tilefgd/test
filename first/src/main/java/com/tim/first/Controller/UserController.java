package com.tim.first.Controller;

import com.tim.first.mapper.UserMapper;
import com.tim.first.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;


    @RequestMapping("/reg")
    public int reg(User user) {
        System.out.println("user = " + user);

        User u = mapper.selectByUseradmin(user.getAdmin());
        if (u != null) {
            return 2;//表示存在

        }
        mapper.insert(user);
        return 1;
        //註冊成功

    }
    @RequestMapping("/login")
    public int login(User user, HttpSession session, String rem) {
        System.out.println("user = " + user + ", session = " + session);
        User u = mapper.selectByUseradmin(user.getAdmin());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                //把當前登入成功的用戶訊息保存在Session對象中
                //u有什麼，取決於我們查了什麼
                session.setAttribute("u", u);
                return 1;//登入成功

            }
            return 3;//密碼錯誤
        }
        return 2;//帳號不存在
    }

}
