package com.scc.service.impl;

import com.scc.dao.DepartmentDao;
import com.scc.dao.EmployeeDao;
import com.scc.domain.Department;
import com.scc.domain.Employee;
import com.scc.service.EmployeeService;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public class EmployeeServiceImpl implements EmployeeService {

//添加员工信息  并更新部门表的人数
    @Override
    public Boolean insert(Employee employee) {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        //更新部门人数
        DepartmentDao deptMapper = sqlSession.getMapper(DepartmentDao.class);
        Integer dept_id = employee.getDept_id();
        List<Employee> emplist = deptMapper.findAllEmpByDepid(dept_id);//找到本部门的所有用户
        int count = emplist.size()+1;
        Department department=new Department(dept_id, null, null, count);

        try {
            mapper.insert(employee);
            deptMapper.updateDeptById(department);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            System.out.println("插入数据失败！");
            return false;
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Override
    public Employee findEmp(Employee employee) {

        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Employee emp = mapper.findEmp(employee);
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询用户信息失败");
            return null;
        }
    }

    //更新员工信息
    @Override
    public void updateEmpById(Employee employee) {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        mapper.updateEmpById(employee);
        sqlSession.commit();
        sqlSession.close();
    }
}
