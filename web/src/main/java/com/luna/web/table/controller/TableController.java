package com.luna.web.table.controller;

import com.luna.common.core.page.TableDataInfo;
import com.luna.web.controller.BaseController;
import com.luna.web.table.entity.OperLog;
import com.luna.web.table.service.IOperLogService;
import com.luna.web.user.dao.UserDAO;
import com.luna.web.user.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/3/24 22:33
 */
@Controller
@RequestMapping("/page")
public class TableController extends BaseController {

    @Autowired
    private IOperLogService operLogService;

    @Autowired
    private UserDAO         userDAO;

    private String          prefix = "page";

    @GetMapping("/operlogC")
    public String table() {
        return prefix + "/operlogClient";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo listByClient(OperLog operLog) {
        // 客户端分页
        List<OperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @PostMapping("/listOper")
    @ResponseBody
    public TableDataInfo list(OperLog operLog) {
        startPage();
        List<OperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @GetMapping("/operlogS")
    public String operlog() {
        return prefix + "/operlog";
    }
}
