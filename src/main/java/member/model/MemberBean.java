package member.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
	private String addr1;
	@NotBlank(message="필수입력 사항입니다.")
	private String addr2;
	@NotBlank(message="필수입력 사항입니다.")
	private String addr3;
	@NotEmpty(message="개인정보 이용에 동의해 주세요.")
	private String agree;
	
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
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	
}
