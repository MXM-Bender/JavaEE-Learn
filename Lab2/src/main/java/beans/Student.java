package beans;

public class Student extends Person {

	private String clazz;
	private String dormitory;
	private String dormitoryNum;

	public Student() {

	}

	public Student(String name, String number, String birthday, String sex, String clazz, String dormitory,
			String dormitoryNum) {
		super(name, number, birthday, sex);
		this.clazz = clazz;
		this.dormitory = dormitory;
		this.dormitoryNum = dormitoryNum;
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
	
	
}
