package com.luna.web.cache.controller;

import com.luna.common.core.domain.AjaxResult;
import com.luna.web.cache.entity.Department;
import com.luna.web.cache.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author luna
 * @since 2020-04-07 20:11:29
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
	/**
	 * 服务对象
	 */
	@Resource
	private DepartmentService departmentService;

	/**
	 * Select list r.
	 *
	 * @param department
	 * @return the r
	 */
	@ApiOperation(value = "查询列表", notes = "查询列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping(value = "/get")
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
	public AjaxResult query(Department department) {
		return AjaxResult.success("查询列表", departmentService.getAll(department));
	}

	/**
	 * Select obj r.
	 *
	 * @param id
	 * @return the r
	 */
	@ApiOperation(value = "查询详情", notes = "查询详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping(value = "/{id}")
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
	public AjaxResult get(@PathVariable("id") Integer id) {
		return AjaxResult.success("查询详情", departmentService.getById(id));
	}

	/**
	 * Insert obj.
	 *
	 * @param department
	 * @return the r
	 */
	@ApiOperation(value = "添加", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping(value = "/add")
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功")})
	public AjaxResult add(@RequestBody Department department) {
		return AjaxResult.success("添加", departmentService.insert(department));
	}

	/**
	 * update obj.
	 *
	 * @param department
	 * @return the r
	 */
	@ApiOperation(value = "更新", notes = "更新", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PutMapping(value = "/")
	@ApiResponses({@ApiResponse(code = 200, message = "修改成功")})
	public AjaxResult update(@RequestBody Department department) {
		return AjaxResult.success("更新", departmentService.update(department));
	}

	/**
	 * delete obj.
	 *
	 * @param id
	 * @return the r
	 */
	@ApiOperation(value = "删除", notes = "删除", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@DeleteMapping(value = "/{id}")
	@ApiResponses({@ApiResponse(code = 200, message = "删除成功")})
	public AjaxResult delete(@PathVariable("id") Integer id) {
		return AjaxResult.success("删除", departmentService.deleteById(id));
	}
}