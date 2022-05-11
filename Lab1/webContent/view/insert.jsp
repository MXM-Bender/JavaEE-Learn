<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息录入</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 25px;">学生信息录入</p>
		<form action="../StudentServlet?type=insert" method="post">
			<table align="center">
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>学号:</td>
					<td><input type="number" name="num" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						<select name="sex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>班级:</td>
					<td><input type="text" name="s_class" /></td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>