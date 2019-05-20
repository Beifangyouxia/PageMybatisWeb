<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>department</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2019/05/19
                    <br/>
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
                Welcome!
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
                        note
                    </td>
                    <td>
                        count
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
               <c:forEach items="${requestScope.allDepartment}" var="dep">
                   <tr class="row1">
                       <td>
                           ${dep.id}
                       </td>
                       <td>
                           ${dep.dname}
                       </td>
                       <td>
                          ${dep.note}
                       </td>
                       <td>
                           ${dep.count}
                       </td>
                       <td>
                           <a href="${pageContext.request.contextPath}/departmentservlet?method=findDepAllEmp&depid=${dep.id}&dname=${dep.dname}">详情</a>
                           <a href="${pageContext.request.contextPath}/departmentservlet?method=updateJump&depid=${dep.id}">update</a>
                       </td>
                   </tr>
               </c:forEach>

            </table>
            <p>
                <input type="button" class="button" value="Add Department" onclick="location='addDepartment.jsp'"/>
                <input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
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
