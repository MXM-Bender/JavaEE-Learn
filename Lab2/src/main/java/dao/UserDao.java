package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao {

	public static boolean login(String id, String passwd) {
		String sql = "select * from user where id=? and passwd=?";
		Connection conn = until.getConnection();
		PreparedStatement pstmt = null;
		ResultSet set = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			set = pstmt.executeQuery();
			if (set.next()) {
				return true;
			}
			close(pstmt, set);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return false;
	}
}
