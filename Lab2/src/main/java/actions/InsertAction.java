package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import beans.Student;
import dao.StudentDao;

public class InsertAction extends ActionSupport {
	private String name;
	private String number;
	private String birthday;
	private String sex;
	private String clazz;
	private String dormitory;
	private String dormitoryNum;

	private List<Student> info = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDormitory() {
		return dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getDormitoryNum() {
		return dormitoryNum;
	}

	public void setDormitoryNum(String dormitoryNum) {
		this.dormitoryNum = dormitoryNum;
	}

	public List<Student> getInfo() {
		return info;
	}

	@Override
	public String execute() throws Exception {
		int result = StudentDao.insert(new Student(name, number, birthday, sex, clazz, dormitory, dormitoryNum));
		if (result > 0) {
			info = StudentDao.getInfo(null, null);
			return SUCCESS;
		}
		return ERROR;
	}
}
