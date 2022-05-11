package beans;

public class Person {
	protected String name;
	protected String number;
	protected String birthday;
	protected String sex;

	public Person() {

	}

	public Person(String name, String number, String birthday, String sex) {
		this.name = name;
		this.number = number;
		this.birthday = birthday;
		this.sex = sex;
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

}
