package com.lovet.controller;

import com.lovet.entity.User;
import com.lovet.enums.UserSexEnum;
import com.lovet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RestController
@RequestMapping("user")
public class UserController {

    volatile private static Long id = 1L;
    volatile private static Long userId = 2L;
    volatile private static Long orderId = 3L;

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    @ResponseBody
    public Map getUsers() {
        List<User> users = userService.getUsers();
        int count = userService.count();
        Map map = new HashMap();
        map.put("count", count);
        map.put("users", users);
        return map;
    }

    //测试
    @RequestMapping(value = "/save")
    @ResponseBody
    public User saveTransactional(@RequestParam(value = "nickName") String nickName,
                                    @RequestParam(value = "passWord") String passWord,
                                    @RequestParam(value = "userName") String userName) {
        Random random = new Random();
        id = random.nextLong();
        userId = random.nextLong();
        orderId = random.nextLong();
        User user2 = new User();
        user2.setId(id);
        user2.setUserId(userId);
        user2.setOrderId(orderId);
        user2.setNickName(nickName + id);
        user2.setPassWord(passWord + id);
        user2.setUserName(userName + id);
        user2.setUserSex(UserSexEnum.WOMAN);
        userService.insertTransactional(user2);
        return user2;
    }
}
