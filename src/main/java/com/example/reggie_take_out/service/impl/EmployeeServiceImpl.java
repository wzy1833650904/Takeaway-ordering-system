package com.example.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.reggie_take_out.common.R;
import com.example.reggie_take_out.entity.Employee;
import com.example.reggie_take_out.mapper.EmployeeMapper;
import com.example.reggie_take_out.service.EmployeeService;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ZEYANG1
 * @description 针对表【employee(员工信息)】的数据库操作Service实现
 * @createDate 2022-09-19 15:21:12
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Resource
    private EmployeeService employeeService;

    public R<Employee> login(@NotNull Employee employee, HttpServletRequest request) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        Employee one = employeeService.getOne(new LambdaQueryWrapper<Employee>()
                .eq(Employee::getUsername, employee.getUsername()));

//        Optional.ofNullable(one).orElseThrow(() -> new RuntimeException("用户名或密码错误"));

        if (ObjectUtils.isEmpty(one)) {
            return R.error("该用户不存在，请注册");
        }
        if (!password.equals(one.getPassword())) {
            return R.error("密码错误!");
        }
        if (one.getStatus() == 0) {
            return R.error("账号已禁用!");
        }
        request.setAttribute("employee", one.getId());
        return R.success(one);
    }
}




