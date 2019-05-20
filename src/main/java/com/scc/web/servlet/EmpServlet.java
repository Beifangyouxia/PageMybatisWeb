package com.scc.web.servlet;

import com.scc.domain.Employee;
import com.scc.service.EmployeeService;
import com.scc.service.impl.EmployeeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * scc
 * 2019/5/19
 */
@WebServlet(name = "EmpServlet",urlPatterns = "/empservlet")
public class EmpServlet extends BaseServlet {

    //注册
   public String regist(HttpServletRequest request, HttpServletResponse response){

       Employee employee=new Employee();
       try {
           BeanUtils.populate(employee, request.getParameterMap());
       } catch (Exception e) {
           e.printStackTrace();
       }
       EmployeeService employeeService=new EmployeeServiceImpl();
       Boolean flag = employeeService.insert(employee);
       if (flag){
           return "/login.jsp";
       }else{
           return "redirect:regist.jps";
       }
   }

   //登录
   public String login(HttpServletRequest request,HttpServletResponse response){

       Employee employee=new Employee();
       try {
           BeanUtils.populate(employee, request.getParameterMap());
       } catch (Exception e) {
           e.printStackTrace();
       }
       EmployeeService service=new EmployeeServiceImpl();
       Employee emp = service.findEmp(employee);
       if (emp!=null){
           return "redirect:departmentservlet?method=findAllDepartment";
       }else{
           request.setAttribute("msg", "登录失败！");
           return "/login.jsp";
       }
   }
   //添加员工信息
    public String addEmployee(HttpServletRequest request,HttpServletResponse response){
       Employee employee=new Employee();
        try {
            BeanUtils.populate(employee, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EmployeeService service=new EmployeeServiceImpl();
        Boolean flag = service.insert(employee);
        String depid=employee.getDept_id()+"";
        System.out.println("depid=============="+depid);
        if (flag){
            String aa="redirect:departmentservlet?method=findDepAllEmp&depid="+depid;
            return  aa;
        }
        return  null;
    }

    //更新员工跳转  传id给updateEmp.jsp  就是为了跳转
    public String updateEmpJump(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        request.setAttribute("id", id);
//        这里有问题-----------------------
        return  "/updateEmp.jsp";
    }

    //updateEmpById  更新员工信息
    public String updateEmpById(HttpServletRequest request,HttpServletResponse response){
        Employee employee=new Employee();
        try {
            BeanUtils.populate(employee, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("employee==================="+employee);
        EmployeeService service=new EmployeeServiceImpl();
        try {
            service.updateEmpById(employee);
            //返回到主界面
            return "redirect:departmentservlet?method=findAllDepartment";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
