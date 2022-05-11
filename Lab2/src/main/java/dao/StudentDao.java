package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Dormitory;
import beans.Student;

public class StudentDao extends Dao {
	public static List<Student> getInfo(String column, String keyword) {
		Connection conn = until.getConnection();
		String sql = null;
		List<Student> result = new ArrayList<Student>();
		if ((column == null || keyword == null) || (column.isBlank() || keyword.isBlank())) {
			sql = "select * from dormitory";
		} else {
			sql = "select * from dormitory where " + column + " like '%" + keyword + "%'";
		}
		System.out.println(sql);
		try {
			Statement stat = conn.createStatement();
			ResultSet set = stat.executeQuery(sql);
			while (set.next()) {
				String name = set.getString("name");
				String birthday = set.getString("birthday");
				String sex = set.getString("sex");
				String clazz = set.getString("clazz");
				String number = set.getString("number");
				String dormitory = set.getString("dormitory");
				String dormitoryNum = set.getString("dormitoryNum");
				Student temp = new Student(name, number, birthday, sex, clazz, dormitory, dormitoryNum);
				result.add(temp);
			}
			close(stat, set);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return result.size() > 0 ? result : null;
	}

	public static int insert(Student stu) {
		Connection connection = until.getConnection();
		String sql = "insert into dormitory(name,sex,birthday,clazz,number,dormitory,dormitorynum)"
				+ "values(?,?,?,?,?,?,?)";
		int reuslt = -1;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getSex());
			pstmt.setString(3, stu.getBirthday());
			pstmt.setString(4, stu.getClazz());
			pstmt.setString(5, stu.getNumber());
			pstmt.setString(6, stu.getDormitory());
			pstmt.setString(7, stu.getDormitoryNum());
			reuslt = pstmt.executeUpdate();
			close(pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return reuslt;
	}

	public static int delete(String num) {
		Connection connection = until.getConnection();
		String sql = "delete from dormitory where number=?";
		int result = -1;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, num);
			result = pstmt.executeUpdate();
			close(pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return result;
	}

	public static int update(String num, Student stu) {
		Connection connection = until.getConnection();
		String sql = "update dormitory set name=?,sex=?,clazz=?,birthday=?,number=?,dormitory=?,dormitorynum=? where number=?";
		int result = -1;
		System.out.println(num);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getSex());
			pstmt.setString(3, stu.getClazz());
			pstmt.setString(4, stu.getBirthday());
			pstmt.setString(5, stu.getNumber());
			pstmt.setString(6, stu.getDormitory());
			pstmt.setString(7, stu.getDormitoryNum());
			pstmt.setString(8, num);
			result = pstmt.executeUpdate();
			close(pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		System.out.println(result);
		return result;
	}

}
