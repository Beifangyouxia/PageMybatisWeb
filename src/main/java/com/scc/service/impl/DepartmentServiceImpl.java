package com.scc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scc.dao.DepartmentDao;
import com.scc.domain.Department;
import com.scc.domain.Employee;
import com.scc.service.DepartmentService;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> findAllDepartment() {

        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        List<Department> allDept = mapper.findAllDept();
        return allDept;
    }

    @Override
    public void addDep(Department department) {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        try {
            mapper.addDep(department);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加部门失败");
            sqlSession.rollback();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    //分页查找员工信息
    @Override
    public PageInfo findAllEmpByDepid(Integer depid, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id");
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        List<Employee> allEmps = mapper.findAllEmpByDepid(depid);
        return new PageInfo(allEmps);
    }

    //更新部门信息
    @Override
    public void updateDept(Department department) {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        System.out.println("deaprtment==========="+department);
        mapper.updateDept(department);
        sqlSession.commit();
        sqlSession.close();
    }
}
