<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍信息修改</title>
</head>
<body>
	<div>
		<h1 align="center">宿舍信息修改</h1>
		<form action="doModify" method="post">
			<input type="hidden" value="${student.number }" name="perNum" />
			<table align="center">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" value="${student.name }"></td>
				</tr>
				<tr>
					<td>学号：</td>
					<td><input type="text" name="number"
						value="${student.number }"></td>
				</tr>
				<tr>
					<td>班级：</td>
					<td><input type="text" name="clazz" value="${student.clazz }"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" name="sex" value="男"
						<s:if test="student.sex==\"男\"">checked</s:if>>男 <input
						type="radio" name="sex" value="女"
						<s:if test="student.sex==\"女\"">checked</s:if>>女</td>
				</tr>

				<tr>
					<td>生日：</td>
					<td><input type="text" name="birthday"
						value="${student.birthday }"></td>
				</tr>
				<tr>
					<td>宿舍楼：</td>
					<td><input type="text" name="dormitory"
						value="${student.dormitory }"></td>
				</tr>
				<tr>
					<td>宿舍号：</td>
					<td><input type="text" name="dormitoryNum"
						value="${student.dormitoryNum }"></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center"><input type="submit" value="修改"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>