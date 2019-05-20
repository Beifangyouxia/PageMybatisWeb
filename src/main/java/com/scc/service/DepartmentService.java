package com.scc.service;

import com.github.pagehelper.PageInfo;
import com.scc.domain.Department;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public interface DepartmentService {
    public List<Department> findAllDepartment();
    //添加部门
    public void addDep(Department department);

    //根据部门id查找所有员工
    public PageInfo findAllEmpByDepid(Integer depid, Integer pageNum, Integer pageSize);

    //更新部门信息
    public void updateDept(Department department);
}
