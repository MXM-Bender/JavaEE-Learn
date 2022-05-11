package bean;

public class Student {
	private String name;
	private String sex;
	private String s_class;
	private String birthday;
	private String num;

	public Student() {

	}

	public Student(String name, String sex, String s_class, String birthday, String num) {
		super();
		this.name = name;
		this.sex = sex;
		this.s_class = s_class;
		this.birthday = birthday;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getS_class() {
		return s_class;
	}

	public void setS_class(String s_class) {
		this.s_class = s_class;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", s_class=" + s_class + ", birthday=" + birthday + ", num="
				+ num + "]";
	}

}
