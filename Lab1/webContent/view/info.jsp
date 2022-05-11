<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息浏览</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 25px;">学生信息浏览</p>
		<p style="text-align: center">
			<input type="button" value="加入学生"
				onclick="javascript: window.location.href='./view/insert.jsp'">
		</p>
		<table align="center" border="1">
			<tr>
				<th>姓名</th>
				<th>学号</th>
				<th>性别</th>
				<th>班级</th>
				<th>生日</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach items="${studentList}" var="list">
				<tr>
					<td>${list.name}</td>
					<td>${list.num}</td>
					<td>${list.sex}</td>
					<td>${list.s_class}</td>
					<td>${list.birthday}</td>
					<td><a href="StudentServlet?type=del&num=${list.num}">删除</a> <a
						href="./StudentServlet?type=modify_1&num=${list.num}">修改信息</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

<script type="text/javascript">
	/*
	window.onload=function(){
		
	}
	 */
</script>
</html>