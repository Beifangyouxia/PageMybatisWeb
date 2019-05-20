package com.scc.dao;

import com.scc.domain.Employee;

/**
 * scc
 * 2019/5/19
 */
public interface EmployeeDao {
    public void insert(Employee employee);

    public Employee findEmp(Employee employee);

    public void updateEmpById(Employee employee);

}
