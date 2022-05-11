package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import dao.UserDao;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	// infos
	private void infos(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Student> students = StudentDao.search(null, null);
		req.setAttribute("studentList", students);
		req.getRequestDispatcher("./view/info.jsp").forward(req, resp);
	}

	private Student getStudentParam(HttpServletRequest req) {
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		String s_class = req.getParameter("s_class");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		Student temp = new Student(name, sex, s_class, birthday, num);
		return temp;
	}

	// login
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userid = req.getParameter("userid");
		String passwd = req.getParameter("passwd");
		String realPasswd = UserDao.login(userid);
		if (passwd.equals(realPasswd)) {
			infos(req, resp);
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write(
					"<script language='javascript'>alert('账号或密码错误!');window.location.href='./view/index.jsp'</script>");
			pw.close();
			pw = null;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String type = req.getParameter("type");
		PrintWriter out = resp.getWriter();

		switch (type) {
		case "login": {
			login(req, resp);
			break;
		}
		case "insert": {
			int result = StudentDao.insert(getStudentParam(req));
			String msg = "";
			if (result == 1) {
				msg = "alert('加入成功');";
			} else {
				msg = "alert('加入失败');";
			}
			out.print("<script language='javascript'>" + msg + "</script>");
			infos(req, resp);
			break;
		}
		case "del": {
			String num = req.getParameter("num");
			String msg = "";
			int result = StudentDao.delete(num);
			if (result == 1) {
				msg = "alert('删除成功');";
			} else {
				msg = "alert('删除失败');";
			}
			out.print("<script language='javascript'>" + msg + "</script>");
			infos(req, resp);
			break;
		}
		case "modify_1": {
			String num = req.getParameter("num");
			Student temp = StudentDao.search(num, "num").get(0);
			req.setAttribute("info", temp);
			req.getRequestDispatcher("./view/modify.jsp").forward(req, resp);
			break;
		}

		case "modify": {
			String pre_num = req.getParameter("pre_num");
			Student temp = getStudentParam(req);
			int result = StudentDao.update(pre_num, temp);
			infos(req, resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		out.close();
		out = null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
