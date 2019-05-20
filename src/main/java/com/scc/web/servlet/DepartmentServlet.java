package com.scc.web.servlet;

import com.github.pagehelper.PageInfo;
import com.scc.domain.Department;
import com.scc.service.DepartmentService;
import com.scc.service.impl.DepartmentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * scc
 * 2019/5/19
 */
@WebServlet(name = "DepartmentServlet",urlPatterns = "/departmentservlet")
public class DepartmentServlet extends BaseServlet {
//查找所有部门
    public String findAllDepartment(HttpServletRequest request, HttpServletResponse response){

        DepartmentService service=new DepartmentServiceImpl();
        List<Department> allDepartment = service.findAllDepartment();
        if (allDepartment!=null){
            request.setAttribute("allDepartment", allDepartment);
            return "/departmentlist.jsp";
        }else{
            request.setAttribute("msg", "请添加部门！");
            return "/departmentlist.jsp";
        }
    }
//添加部门
    public String addDepartment(HttpServletRequest request, HttpServletResponse response){

        Department department=new Department();
        try {
            BeanUtils.populate(department, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DepartmentService service=new DepartmentServiceImpl();
        try {
            service.addDep(department);
            return "redirect:addDepartment.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加部门失败.................");
        }
        return null;
    }
//查询当前部门下的所有员工信息 分页查询
    public String findDepAllEmp(HttpServletRequest request, HttpServletResponse response){
        String depid = request.getParameter("depid");
        String dname = request.getParameter("dname");
        String pageNum1 = request.getParameter("pageNum");
        String pageSize1 = request.getParameter("pageSize");

        Integer pageNum=1;
        Integer pageSize=10;
        if (pageNum1!=null&&pageSize1!=null){
            pageNum=Integer.parseInt(pageNum1);
            pageSize=Integer.parseInt(pageSize1);
        }

        DepartmentService service=new DepartmentServiceImpl();
        PageInfo page = service.findAllEmpByDepid(Integer.parseInt(depid), pageNum, pageSize);
        request.setAttribute("page", page);
        request.setAttribute("dname", dname);
        return "/emplist.jsp";

    }
    //部门更新跳转
    public String updateJump(HttpServletRequest request, HttpServletResponse response){
        String depid = request.getParameter("depid");
        request.setAttribute("depid", depid);
        return "/updateDept.jsp";
    }


    //更新部门信息
    public String updateDept(HttpServletRequest request, HttpServletResponse response){

        Department department=new Department();

        try {
            BeanUtils.populate(department, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DepartmentService service=new DepartmentServiceImpl();

        try {
            service.updateDept(department);
            return "redirect:departmentservlet?method=findAllDepartment";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }

}
