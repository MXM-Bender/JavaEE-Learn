package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	protected static SQLUntil until = new SQLUntil();

	protected static void close(Statement stmt, ResultSet set) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (set != null) {
				set.close();
				set = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
