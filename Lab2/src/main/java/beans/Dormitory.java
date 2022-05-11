package beans;

public class Dormitory {
	private String dormitory;
	private String dormitoryNum;

	public Dormitory() {

	}

	public Dormitory(String dormitory, String dormitoryNum) {
		super();
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

}
