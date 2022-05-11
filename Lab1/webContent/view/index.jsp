<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 25px;">登录</p>

		<form action="../StudentServlet?type=login" method="post">
			<table align="center">
				<tr>
					<td>账号：</td>
					<td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr style="text-align: center;">
					<td><input type="submit" value="登录"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>