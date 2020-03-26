package com.luna.web.table.mapper;

import com.luna.web.table.entity.OperLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作日志 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface OperLogMapper {
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(OperLog operLog);

    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
//    @Select(" select oper_id, title, business_type, method, request_method, operator_type, oper_name, dept_name, oper_url, oper_ip, oper_location, oper_param, json_result, status, error_msg, oper_time from sys_oper_log order by  oper_id")
//    @Results({
//        @Result(property = "operId", column = "oper_id"),
//        @Result(property = "title", column = "title"),
//        @Result(property = "businessType", column = "business_type"),
//        @Result(property = "method", column = "method"),
//        @Result(property = "requestMethod", column = "request_method"),
//        @Result(property = "operatorType", column = "operator_type"),
//        @Result(property = "operName", column = "oper_name"),
//        @Result(property = "deptName", column = "dept_name"),
//        @Result(property = "operUrl", column = "oper_url"),
//        @Result(property = "operIp", column = "oper_ip"),
//        @Result(property = "operLocation", column = "oper_location"),
//        @Result(property = "operParam", column = "oper_param"),
//        @Result(property = "jsonResult", column = "json_result"),
//        @Result(property = "status", column = "status"),
//        @Result(property = "errorMsg", column = "error_msg"),
//        @Result(property = "operTime", column = "oper_time"),
//    })
    public List<OperLog> selectOperLogList(OperLog operLog);

    /**
     * 批量删除系统操作日志
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteOperLogByIds(String[] ids);

    /**
     * 查询操作日志详细
     * 
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public OperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    public void cleanOperLog();
}
