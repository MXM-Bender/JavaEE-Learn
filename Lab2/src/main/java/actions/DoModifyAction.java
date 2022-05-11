package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import beans.Student;
import dao.StudentDao;

public class DoModifyAction extends ActionSupport {

	private String perNum;

	private String name;
	private String number;
	private String birthday;
	private String sex;
	private String clazz;
	private String dormitory;
	private String dormitoryNum;

	private List<Student> info;

	public List<Student> getInfo() {
		return info;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

	public void setInfo(List<Student> info) {
		this.info = info;
	}

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

	@Override
	public String execute() throws Exception {
		System.out.println(perNum);
		int result = StudentDao.update(perNum,
				new Student(name, number, birthday, sex, clazz, dormitory, dormitoryNum));
		if (result > 0) {
			info = StudentDao.getInfo(null, null);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
