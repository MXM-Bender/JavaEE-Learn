package actions;

import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Student;
import dao.StudentDao;

public class ModifyAction extends ActionSupport {

	private String perNum;

	private Student student = new Student();

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

	public Student getStudent() {
		return student;
	}

	@Override
	public String execute() throws Exception {
		List<Student> result = StudentDao.getInfo("number", perNum);
		if (result != null) {
			student = result.get(0);
			System.out.println(student.getSex());
		}
		return SUCCESS;
	}
}
