package com.scc.test;

import com.scc.dao.EmployeeDao;
import com.scc.domain.Employee;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * scc
 * 2019/5/19
 */
public class TestEmp {
    @Test
    public void inset(){
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee=new Employee(null, "hupo", "123456", "hupoxiansheng",
                "男", new Date(), new BigDecimal(20000), 23, 2001);
        try {
            mapper.insert(employee);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入异常。。。");
            sqlSession.rollback();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    //批量插入数据
    @Test
    public void add(){
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        for (int i=1;i<=50;i++){
            Employee employee=new Employee(null, "zhangsan"+i, "123", "zhang123", "女", new Date()
            , new BigDecimal(15000), 18, 2001);
            mapper.insert(employee);
            sqlSession.commit();
        }
        sqlSession.close();
    }
}
