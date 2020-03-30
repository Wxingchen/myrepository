<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="/teacher/get/1">查询001号员工</a><br>
<a href="/teacher/get/2">查询002号员工</a><br>
<a href="/teacher/getAll">查询所有员工</a><br>
<br/>
<br/>
<br/>
<%--<form action="/teacher/save" method="post">
    姓名:<input type="text" name="username"><br/>
    年龄:<input type="text" name="age"><br/>
    生日:<input type="text" name="birthday"><br/>
    <input type="submit" value="提交">
</form>--%>
<h2>传统文件上传</h2>
<form action="/user/commonsUploadFile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/><br/>
    <input type="submit" value="点击上传"/>
</form>
<br/>
<br/>
<br/>
<h2>springmvc文件上传</h2>
<form action="/user/springmvcUploadFile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/><br/>
    <input type="submit" value="点击上传"/>
</form>

<h2>springmvc跨服务器文件上传</h2>
<form action="/user/springmvcCrossUploadFile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/><br/>
    <input type="submit" value="点击上传"/>
</form>
</body>
</html>
