package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDao extends Dao {

	public static int insert(Student stu) {
		Connection connection = until.getConnection();
		String sql = "insert into student(name,sex,s_class,birthday,num)" + "values(?,?,?,?,?)";
		int reuslt = -1;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getSex());
			pstmt.setString(3, stu.getS_class());
			pstmt.setString(4, stu.getBirthday());
			pstmt.setString(5, stu.getNum());
			reuslt = pstmt.executeUpdate();
			close(pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		System.out.println(connection);
		return reuslt;
	}

	public static List<Student> search(String key, String column) {
		Connection connection = until.getConnection();
		String sql = "select * from student where ";
		if (key == null || key.equals("")) {
			sql += "1=1;";
		} else {
			sql += column + "='" + key + "';";
		}
		List<Student> results = new ArrayList<Student>();
		try {
			Statement state = connection.createStatement();
			ResultSet set = state.executeQuery(sql);
			while (set.next()) {
				String name = set.getString("name");
				String sex = set.getString("sex");
				String clazz = set.getString("clazz");
				String birthday = set.getString("birthday");
				String num = set.getString("num");
				Student temp = new Student(name, sex, clazz, birthday, num);
				results.add(temp);
			}
			close(state, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return results;
	}

	public static int update(String num, Student student) {
		Connection connection = until.getConnection();
		String sql = "update student set name=?,sex=?,s_class=?,birthday=?,num=? where num=?";
		int result = -1;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSex());
			pstmt.setString(3, student.getS_class());
			pstmt.setString(4, student.getBirthday());
			pstmt.setString(5, student.getNum());
			pstmt.setString(6, num);
			result = pstmt.executeUpdate();
			close(pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			until.close();
		}
		return result;
	}

	public static int delete(String num) {
		Connection connection = until.getConnection();
		String sql = "delete from student where num=?";
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

	public static void main(String[] args) {
		List<Student> result = search(null, null);
		System.out.println(result.size());
	}
}
