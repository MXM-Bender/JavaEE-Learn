<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍信息添加</title>
</head>
<body>
	<div>
		<h1 align="center">宿舍信息添加</h1>
		<form action="add" method="post">
			<table align="center">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>学号：</td>
					<td><input type="text" name="number"></td>
				</tr>
				<tr>
					<td>班级：</td>
					<td><input type="text" name="clazz"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" name="sex" value="男">男 <input
						type="radio" name="sex" value="女">女</td>
				</tr>

				<tr>
					<td>生日：</td>
					<td><input type="text" name="birthday"></td>
				</tr>
				<tr>
					<td>宿舍楼：</td>
					<td><input type="text" name="dormitory"></td>
				</tr>
				<tr>
					<td>宿舍号：</td>
					<td><input type="text" name="dormitoryNum"></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center">
						<input type="reset" value="重置">
						<input type="submit" value="提交">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>