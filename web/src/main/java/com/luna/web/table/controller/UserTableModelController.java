package com.luna.web.table.controller;


import com.luna.common.annotation.Log;
import com.luna.common.core.domain.AjaxResult;
import com.luna.common.core.page.PageDomain;
import com.luna.common.core.page.TableDataInfo;
import com.luna.common.core.page.TableSupport;
import com.luna.common.core.text.Convert;
import com.luna.common.enums.BusinessType;
import com.luna.common.utils.StringUtils;

import com.luna.web.controller.BaseController;
import com.luna.web.table.entity.UserTableModel;
import com.luna.web.table.mapper.UserTableModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 表格相关
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/pageUser")
public class UserTableModelController extends BaseController {
	private String prefix = "pageUser";

	@Autowired
	private UserTableModelDAO userTableModelDAO;

	private static List<UserTableModel> users =  new ArrayList<>();


	/**
	 * 新增操作
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap) {
		System.out.println("跳转到添加页面");
		return prefix + "/add";
	}

	/**
	 * 新增保存操作
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@Validated UserTableModel userDO) {
		System.out.println(userDO.toString());
		System.out.println("先做简单的逻辑校验 然后调用service方法存入数据库");
		AjaxResult ajaxResult = toAjax(userTableModelDAO.insertByAjax(userDO));
		System.out.println("返回封装Ajax数据 类ResultDO");
		return ajaxResult;
	}

	/**
	 * 修改操作
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
		System.out.println(userId);
		System.out.println("获取路径变量上的id 调service方法查出数据回显 放置回显信息 跳转页面");
		return prefix + "/edit";
	}

	/**
	 * 修改保存操作
	 */
	@Log(title = "操作管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult updateUser(@Validated UserTableModel userDO) {
		System.out.println(userDO);
		System.out.println("先做简单的逻辑校验 然后调用service方法修改数据 返回封装Ajax数据 类ResultDO");
		return toAjax(userTableModelDAO.update(userDO));
	}

	/**
	 * 删除操作
	 */
	@Log(title = "删除操作", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult removeByAjax(String ids) {
		System.out.println(ids);
		Integer[] userIds = Convert.toIntArray(ids);
		System.out.println("首先将ids 转为数组 调用service方法批量删除 返回ajax");
		for (Integer userId : userIds) {
			return toAjax(userTableModelDAO.deleteByAjax(userId));
		}
		return toAjax(1);
	}

	@GetMapping("/users")
	public String table() {
		return prefix + "/user";
	}

	/**
	 * 查询数据
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserTableModel userModel) {
		users= userTableModelDAO.getAll();
		TableDataInfo rspData = new TableDataInfo();
		List<UserTableModel> userList = new ArrayList<UserTableModel>(Arrays.asList(new UserTableModel[users.size()]));
		Collections.copy(userList, users);
		// 查询条件过滤
		if (StringUtils.isNotEmpty(userModel.getUserName())) {
			userList.clear();
			for (UserTableModel user : users) {
				if (user.getUserName().equals(userModel.getUserName())) {
					userList.add(user);
				}
			}
		}
		PageDomain pageDomain = TableSupport.buildPageRequest();
		if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
			rspData.setRows(userList);
			rspData.setTotal(userList.size());
			return rspData;
		}
		Integer pageNum = (pageDomain.getPageNum() - 1) * 10;
		Integer pageSize = pageDomain.getPageNum() * 10;
		if (pageSize > userList.size()) {
			pageSize = userList.size();
		}
		rspData.setRows(userList.subList(pageNum, pageSize));
		rspData.setTotal(userList.size());
		return rspData;
	}
}

