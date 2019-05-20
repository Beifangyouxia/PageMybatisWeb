package com.scc.test;

import com.scc.dao.DepartmentDao;
import com.scc.domain.Department;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * scc
 * 2019/5/20
 */
public class TestDept {
    @Test
    public void update(){
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department department=new Department(2004, "后勤123", "后勤123", null);
        mapper.updateDept(department);
        sqlSession.commit();

    }
}
