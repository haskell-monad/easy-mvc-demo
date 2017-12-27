<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/18
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>爱康讲座报名列表</title>
</head>
<body>
<span>爱康讲座报名列表</span>
<span>=================================已报名用户===========================================</span>
<table border=1 width="100%">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>手机号</th>
        <th>部门</th>
        <th>注册时间</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="vs">
        <tr>
            <td>${vs.index + 1}</td>
            <td align="center">${user.userName}</td>
            <td align="center">${user.userPhone}</td>
            <td align="center">${user.department}</td>
            <td align="center">${user.createDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
