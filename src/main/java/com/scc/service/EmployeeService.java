package com.scc.service;

import com.scc.domain.Employee;

/**
 * scc
 * 2019/5/19
 */
public interface EmployeeService {
    //插入用户
    public Boolean insert(Employee employee);

    //查询用户
    public Employee findEmp(Employee employee);

    public void updateEmpById(Employee employee);
}
