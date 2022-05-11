<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息修改</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 25px;">学生信息修改</p>
		<form action="./StudentServlet?type=modify&pre_num=${info.num}"
			method="post">
			<table align="center">
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="name" value="${info.name}" /></td>
				</tr>
				<tr>
					<td>学号:</td>
					<td><input type="number" name="num" value="${info.num }" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><select name="sex">
							<option value="男"
								<c:if test="${info.sex==\"男\" }">
								selected
							</c:if>>男</option>
							<option value="女"
								<c:if test="${info.sex==\"女\" }">
								selected
							</c:if>>女</option>
					</select></td>
				</tr>
				<tr>
					<td>班级:</td>
					<td><input type="text" name="s_class" value="${info.s_class }" /></td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><input type="text" name="birthday"
						value="${info.birthday }" /></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="修改"></td>
				</tr>
				</form>

				</div>
</body>
</html>