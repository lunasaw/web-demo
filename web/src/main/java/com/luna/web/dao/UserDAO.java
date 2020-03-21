package com.luna.web.dao;

import com.luna.web.entity.User;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.DateUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/21 19:40
 */
@Component
public class UserDAO {

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User("张三", 1);
        User user2 = new User("李四", 2);

        user1.setGender(1);
        user2.setGender(0);
        Date date1 = new Date();
        user1.setBirth(date1);

	    Calendar calendar = DateUtils.create("1999", "11", "07");
	    Date time = calendar.getTime();
	    user2.setBirth(time);

        users.add(user1);
        users.add(user2);
        return users;
    }

}
