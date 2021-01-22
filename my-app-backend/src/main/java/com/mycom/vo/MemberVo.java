package com.mycom.vo;

public class MemberVo {
	private int no;
	private String name;
	private String phone;
	private String gender;
	
	public MemberVo() {}
	
	public MemberVo(int no, String name, String phone, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", phone=" + phone + ", gender=" + gender + "]";
	}
	
	
	
}
