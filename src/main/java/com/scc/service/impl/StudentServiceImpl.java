package com.scc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scc.dao.StudentDao;
import com.scc.domain.Student;
import com.scc.service.StudentService;
import com.scc.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public PageInfo findStudentByPage(Integer pageNum, Integer pageSize) {
        //使用分页工具设置页号和每页数据个数
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("startPage====");
        SqlSession sqlSession = SessionUtil.getSqlSessionIntance();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        System.out.println("get sqsession");
        List<Student> studets = mapper.findAllStudent();
        System.out.println("find all Studnt");
        sqlSession.close();//mybatis 的连接池个数有限  大概8个左右 需要关闭
        //若是不关闭，当默认的最大连接数用完了就需要自动关闭其他没有的连接 这个就慢
        return new PageInfo<>(studets);
    }
}
