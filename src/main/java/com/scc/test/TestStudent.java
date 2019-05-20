package com.scc.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scc.dao.StudentDao;
import com.scc.domain.Student;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * scc
 * 2019/5/17
 */
public class TestStudent {
    @Test
    public void findAllStudnet() {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(2, 5);//第一个是页码 第二个是每页数据个数
        PageHelper.orderBy("studentNo");//排序方式
        List<Student> students = mapper.findAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }

        PageInfo<Student> pageInfo = new PageInfo<>(students);
        System.out.println("----=================");
    }

    @Test
    public void add() {
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        for (int i = 1; i <= 500; i++) {
            Student student = new Student(i, "123", "zhangsan" + i, "男", new Date());
            mapper.addStudent(student);
            sqlSession.commit();
        }
        System.out.println("插入完毕");
        sqlSession.close();

    }
}
