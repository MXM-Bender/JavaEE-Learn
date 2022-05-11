package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao {

	public static String login(String id) {
		Connection connection = until.getConnection();
		String passwd = null;
		String sql = "select passwd from user where id = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
				passwd = set.getString(1);
			}
			close(pstmt, set);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}

		return passwd;
	}
}
