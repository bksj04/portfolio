package member.model;

import javax.validation.constraints.NotBlank;

public class MemberBean {
	private int num;
	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String id;
	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String password;
	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String name;
	
	private String regdate;

	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String tel;
	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String email;
	@NotBlank(message="�ʼ��Է� �����Դϴ�.")
	private String address;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
