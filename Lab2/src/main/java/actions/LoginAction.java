package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import beans.Student;
import dao.StudentDao;
import dao.UserDao;

public class LoginAction extends ActionSupport {

	private String id;
	private String passwd;

	private List<Student> info = null;

	public List<Student> getInfo() {
		return info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String execute() throws Exception {
		if (UserDao.login(id, passwd)) {
			info = StudentDao.getInfo(null, null);
			return SUCCESS;
		}
		return ERROR;
	}

}
