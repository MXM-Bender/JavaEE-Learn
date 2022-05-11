package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLUntil {

	private Connection connection = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String userName = "root";
	private String passwd = "xxzj541";
	private String url = "jdbc:mysql://127.0.0.1:3306/studentmag?serverTimezone=UTC";

	private void init() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		init();
		return connection;
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connection = null;
	}
}
