package com.scc.web.servlet;

import com.github.pagehelper.PageInfo;
import com.scc.service.StudentService;
import com.scc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * scc
 * 2019/5/19
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/studentservlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//分页查询学生信息
        String pageNumstr = request.getParameter("pageNum");
        String pageSizestr = request.getParameter("pageSize");
        //设置默认分页参数
        Integer pageNum = 1;
        Integer pageSize = 10;
        if (pageNumstr != null && pageSizestr != null) {
            pageNum = Integer.parseInt(pageNumstr);
            pageSize = Integer.parseInt(pageSizestr);
        }
        StudentService studentService = new StudentServiceImpl();
        PageInfo page = studentService.findStudentByPage(pageNum, pageSize);
        System.out.println("=====："+page.getPageNum());
        request.setAttribute("page", page);
        request.setAttribute("hello", "hello cc");
        request.getRequestDispatcher("/WEB-INF/studentlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
