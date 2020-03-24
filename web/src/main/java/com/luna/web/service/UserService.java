package com.luna.web.service;

import com.luna.web.dao.UserDAO;
import com.luna.web.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/24 16:35
 */
@Service("dict")
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public List<UserDO> getType() {
		return userDAO.getAll();
	}

	public String getMessage() {
		return "html方式调用后台";
	}

	public String getMessageByParam(String msg) {
		return "Service=>" + msg;
	}

}
