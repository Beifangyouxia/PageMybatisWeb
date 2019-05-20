<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表分页查询</title>
</head>
<body>

<h1>学生列表分页查询</h1>
<table>
    <tr>
        <td>学号</td>
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>出生日期</td>
    </tr>
    <c:forEach items="${requestScope.page.list}" var="stu">
        <tr>
            <td>${stu.studentNo}</td>
            <td>${stu.loginPwd}</td>
            <td>${stu.studentName}</td>
            <td>${stu.sex}</td>
            <td>${stu.bornDate}</td>
        </tr>
    </c:forEach>
</table>
<div id="nav">
    <%--首页--%>
    <a href="${pageContext.request.contextPath}/studentservlet?pageNum=1&pageSize=${requestScope.page.pageSize}">首页</a>
    <%--上一页--%>
    <c:if test="${requestScope.page.pageNum>1}">
        <a href="${pageContext.request.contextPath}/studentservlet?pageNum=${requestScope.page.prePage}&pageSize=${requestScope.page.pageSize}">上一页</a>
    </c:if>

    <%--页号导航--%>
    <c:forEach begin="${requestScope.page.navigateFirstPage}" end="${requestScope.page.navigateLastPage}" var="n">
        <c:if test="${n==requestScope.page.pageNum}">
            <a href="${pageContext.request.contextPath}/studentservlet?pageNum=${n}&pageSize=${requestScope.page.pageSize}" style="color: blueviolet;font-weight: bold">${n}</a>
        </c:if>
        <c:if test="${n!=requestScope.page.pageNum}">
            <a href="${pageContext.request.contextPath}/studentservlet?pageNum=${n}&pageSize=${requestScope.page.pageSize}">${n}</a>
        </c:if>
    </c:forEach>
    <%--下一页--%>
    <c:if test="${requestScope.page.pageNum<requestScope.page.pages}">
        <a href="${pageContext.request.contextPath}/studentservlet?pageNum=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}">下一页</a>
    </c:if>
    <%--尾页--%>
    <a href="${pageContext.request.contextPath}/studentservlet?pageNum=${requestScope.page.pages}&pageSize=${requestScope.page.pageSize}">尾页</a>
    <%--显示当前第几页--%>
    <sapn>共【${requestScope.page.pageNum}/${requestScope.page.pages}】</sapn>
    <%--页面跳转--%>
    <input type="text" id="num"><input type="button" value="跳转" onclick="changeNum()">
    <script type="text/javascript">
        function changeNum() {
            var num = document.getElementById("num").value;
            if (isNaN(num)) {
                alert("你填写的不是数字！")
                return;
            }
            if (num < 1) {
                alert("请填写大于0的数！")
                return;
            }
            window.location = '${pageContext.request.contextPath}/studentservlet?pageNum=' + num + '&pageSize=${requestScope.page.pageSize}';
        }
    </script>
</div>
</body>
</html>
