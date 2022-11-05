package com.example.reggie_take_out.controller;

import com.example.reggie_take_out.common.R;
import com.example.reggie_take_out.entity.Employee;
import com.example.reggie_take_out.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ZEYANG1
 */
@Slf4j
@RequestMapping("/employee")
@RestController
@Api("用户登录")
public class EmployeeController {

    @Resource
    private EmployeeServiceImpl employeeService;

    @PostMapping("/login")
    @ApiOperation("系统登录")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest request) {
        return employeeService.login(employee, request);
    }

    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public R<String> logout(HttpServletRequest request){
        return employeeService.logout(request);
    }

}
