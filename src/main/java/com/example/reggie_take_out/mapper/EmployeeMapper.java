package com.example.reggie_take_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.reggie_take_out.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZEYANG1
 * @description 针对表【employee(员工信息)】的数据库操作Mapper
 * @createDate 2022-09-19 15:21:12
 * @Entity com.example.reggie_take_out.entity.Employee
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}




