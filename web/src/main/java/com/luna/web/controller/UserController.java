package com.luna.web.controller;

import com.luna.web.dao.UserDAO;
import com.luna.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/21 19:33
 */
@Controller
public class UserController {

	@Resource
    private UserDAO userDAO;

    /**
     * 查询所有
     * 
     * @return
     */
    @GetMapping("/users")
    public String list(ModelMap map) {
        List<User> all = userDAO.getAll();
        map.put("users", all);
        return "user/users";
    }

}
