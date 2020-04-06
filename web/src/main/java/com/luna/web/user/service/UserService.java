package com.luna.web.user.service;

import com.luna.web.jpa.controller.JpaUserController;
import com.luna.web.user.dao.UserDAO;
import com.luna.web.user.entity.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/24 16:35
 */
@Service("dict")
public class UserService {

	private static final  Logger log = LoggerFactory.getLogger(UserService.class);


	@Autowired
	private UserDAO userDAO;

	public List<UserDO> getType() {
		return userDAO.getAll();
	}

	public String getMessage() {
		log.info("html方式调用后台");
		return "html方式调用后台";
	}

	public String getMessageByParam(String msg) {
		return "Service=>" + msg;
	}

}
