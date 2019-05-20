<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/5/19
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                全部员工
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
                        Dept
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <tr class="row1">
                    <td>
                        1
                    </td>
                    <td>
                        zhangshan
                    </td>
                    <td>
                        20000
                    </td>
                    <td>
                        20
                    </td>
                    <td>
                        2019-12-12
                    </td>
                    <td>
                        教学部
                    </td>
                    <td>
                        <a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
                    </td>
                </tr>
                <tr class="row2">
                    <td>
                        2
                    </td>
                    <td>
                        lishi
                    </td>
                    <td>
                        20000
                    </td>
                    <td>
                        20
                    </td>
                    <td>
                        2019-12-13
                    </td>
                    <td>
                        教研部
                    </td>
                    <td>
                        <a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
                    </td>
                </tr>
            </table>
            <a href="#" style="display: inline-block;margin-right: 10px;margin-bottom: 9px;font-size: large;text-decoration:none">1</a>
            <a href="#" style="display: inline-block;margin-right: 10px;margin-bottom: 9px;font-size: large;font-weight: bolder;text-decoration:none">2</a>
            <a href="#" style="display: inline-block;margin-right: 10px;margin-bottom: 9px;font-size: large;text-decoration:none">3</a>

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