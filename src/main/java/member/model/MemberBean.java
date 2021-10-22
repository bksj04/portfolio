package member.model;

import javax.validation.constraints.NotBlank;

public class MemberBean {
	private int num;
	@NotBlank(message="필수입력 사항입니다.")
	private String id;
	@NotBlank(message="필수입력 사항입니다.")
	private String password;
	@NotBlank(message="필수입력 사항입니다.")
	private String name;
	
	private String regdate;

	@NotBlank(message="필수입력 사항입니다.")
	private String tel;
	@NotBlank(message="필수입력 사항입니다.")
	private String email;
	@NotBlank(message="필수입력 사항입니다.")
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
