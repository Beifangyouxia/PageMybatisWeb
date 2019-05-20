<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                <%--显示部门名称--%>
                ${requestScope.dname}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Hire Date
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <%--分页显示用户信息--%>
               <c:forEach items="${requestScope.page.list}" var="emp">
                   <tr class="row1">
                       <td>
                           ${emp.id}
                       </td>
                       <td>
                           ${emp.realname}
                       </td>
                       <td>
                           ${emp.salary}
                       </td>
                       <td>
                           ${emp.age}
                       </td>
                       <td>
                           ${emp.hiredate}
                       </td>
                       <td>
                           <a href="emplist.html">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/empservlet?updateEmpJump&id=${emp.id}">update emp</a>
                       </td>
                   </tr>
               </c:forEach>

            </table>
            <%--页号导航--%>
            <c:forEach begin="${requestScope.page.navigateFirstPage}" end="${requestScope.page.navigateLastPage}" var="n">
                <c:if test="${n==requestScope.page.pageNum}">
                    <a href="${pageContext.request.contextPath}/departmentservlet?method=findDepAllEmp&depid=${requestScope.page.list[0].dept_id}&pageNum=${n}&pageSize=${requestScope.page.pageSize}" style="display: inline-block;margin-right: 10px;margin-bottom: 9px;font-size: large;font-weight: bolder;text-decoration:none">${n}</a>
                </c:if>
                <c:if test="${n!=requestScope.page.pageNum}">
                    <a href="${pageContext.request.contextPath}/departmentservlet?method=findDepAllEmp&depid=${requestScope.page.list[0].dept_id}&pageNum=${n}&pageSize=${requestScope.page.pageSize}" style="display: inline-block;margin-right: 10px;margin-bottom: 9px;font-size: large;text-decoration:none">${n}</a>
                </c:if>
            </c:forEach>


            <p>
                <a href="${pageContext.request.contextPath}/departmentservlet?method=findAllDepartment">返回到主页</a>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
