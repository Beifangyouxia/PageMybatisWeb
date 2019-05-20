package com.scc.dao;

import com.scc.domain.Department;
import com.scc.domain.Employee;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public interface DepartmentDao {
    public List<Department> findAllDept();

    //更新部门信息
    public void updateDept(Department department);

    //增加部门
    public void addDep(Department department);

    //查找当前部门下的所有员工
    public List<Employee> findAllEmpByDepid(Integer depid);

    //根据部门id来更新部门人数
    public void updateDeptById(Department department);


}
