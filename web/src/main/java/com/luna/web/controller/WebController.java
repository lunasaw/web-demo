package com.luna.web.controller;

import com.luna.web.entity.UserDO;
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
	    List<UserDO> users = new ArrayList<>();
	    UserDO user1 = new UserDO("张三", 1);
	    UserDO user2 = new UserDO("李四", 2);

        users.add(user1);
        users.add(user2);

        map.put("user1", user1);
        map.put("users", users);

	    Map<String, UserDO> userMap = new HashMap<>();
        userMap.put("user1", user1);
        userMap.put("user2", user2);
        map.put("userMap", userMap);

	    UserDO[] userArray = new UserDO[]{user1, user2};
        map.put("userArray", userArray);

        return "thymeleaf/demoObject";
    }



}
