<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <h2>恭喜您，已经加载成功!!!</h2><br>
<table cellpadding="5" cellspacing="0" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>course</th>
        <th>address</th>
    </tr>
    <c:forEach items="${info.list}" var="teacher" >
        <tr>
            <th>${teacher.id}</th>
            <th>${teacher.name}</th>
            <th>${teacher.course}</th>
            <th>${teacher.address}</th>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="/teacher/getAll?pn=1">首页</a>
            <a href="/teacher/getAll?pn=${info.prePage}">上一页</a>
            <c:forEach items="${info.navigatepageNums}" var="num">
                <c:if test="${info.pageNum == num}">
                    <a href="/teacher/getAll?pn=${num}">【${num}】</a>
                </c:if>
                <c:if test="${info.pageNum != num}">
                    <a href="/teacher/getAll?pn=${num}">${num}</a>
                </c:if>
            </c:forEach>

            <a href="/teacher/getAll?pn=${info.nextPage}">下一页</a>
            <a href="/teacher/getAll?pn=${info.pages}">末页</a>

        </td>
    </tr>
</table>

</body>
</html>
