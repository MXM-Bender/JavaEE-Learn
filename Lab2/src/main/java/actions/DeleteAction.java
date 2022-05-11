package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import beans.Student;
import dao.StudentDao;

public class DeleteAction extends ActionSupport {
	private String num;

	private List<Student> info = null;

	public List<Student> getInfo() {
		return info;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String execute() throws Exception {
		int result = StudentDao.delete(num);
		if (result > 0) {
			info = StudentDao.getInfo(null, null);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
