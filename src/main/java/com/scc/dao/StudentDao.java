package com.scc.dao;

import com.scc.domain.Student;

import java.util.List;

/**
 * scc
 * 2019/5/17
 */
public interface StudentDao {
    public List<Student> findAllStudent();
    public void addStudent(Student student);
}
