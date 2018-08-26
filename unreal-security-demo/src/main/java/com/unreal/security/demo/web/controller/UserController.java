package com.unreal.security.demo.web.controller;

import com.unreal.security.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 23:51 2018/8/15
 */
@RestController
public class UserController {

    @GetMapping(name = "/user")
    public List<User> query(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("zhangsan");
        users.add(user);
        return users;
    }
}
