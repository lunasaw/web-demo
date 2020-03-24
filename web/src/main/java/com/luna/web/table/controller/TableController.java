package com.luna.web.table.controller;

import com.luna.common.core.page.TableDataInfo;
import com.luna.web.controller.BaseController;
import com.luna.web.user.dao.UserDAO;
import com.luna.web.user.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/24 22:33
 */
@Controller
@RequestMapping("/demo/user")
public class TableController extends BaseController {

	@Autowired
	private UserDAO userDAO;

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserDO user) {
		startPage();
		List<UserDO> list = userDAO.getAll();
		return getDataTable(list);
	}
}
