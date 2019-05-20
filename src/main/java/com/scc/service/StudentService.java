package com.scc.service;

import com.github.pagehelper.PageInfo;

/**
 * scc
 * 2019/5/19
 */
public interface StudentService {
    public PageInfo findStudentByPage(Integer pageNum,Integer pageSize);

}
