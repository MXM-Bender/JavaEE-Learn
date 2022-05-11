<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍信息</title>
</head>
<body>
	<div>
		<h1 align="center">宿舍信息管理</h1>
		<h3 align="center">
			<a href="./insert.jsp">添加信息</a>
		</h3>
		<table align="center" border="1">
			<thead>
				<tr align="center">
					<th>姓名</th>
					<th>学号</th>
					<th>班级</th>
					<th>性别</th>
					<th>生日</th>
					<th>宿舍楼</th>
					<th>宿舍号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="info">
					<tr align="center">
						<td>${name }</td>
						<td>${number}</td>
						<td>${clazz}</td>
						<td>${sex}</td>
						<td>${birthday}</td>
						<td>${dormitory}</td>
						<td>${dormitoryNum}</td>
						<td colspan="2"><a href="delete?num=${number}">删除</a> <a
							href="modify?preNum=${number }">修改</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>