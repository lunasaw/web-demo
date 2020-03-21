package com.luna.web.controller;

import com.luna.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luna@win10
 * @date 2020/3/21 14:15
 */
@Controller
public class WebController {

    @GetMapping("demo")
    public String web(ModelMap map) {
        List<User> users = new ArrayList<>();
        User user1 = new User("张三", 18);
        User user2 = new User("李四", 20);

        users.add(user1);
        users.add(user2);

        map.put("user1", user1);
        map.put("users", users);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("user1", user1);
        userMap.put("user2", user2);
        map.put("userMap", userMap);

        User[] userArray = new User[] {user1, user2};
        map.put("userArray", userArray);



        return "thymeleaf/demo_3_21";
    }

}
