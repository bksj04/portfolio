package category.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class CategoryBean {
	
	private int num;
	@NotBlank(message = "제목을 입력해주세요")
	private String title;
	@NotBlank(message = "카테고리를 선택해주세요")
	private String category;
	@NotBlank(message = "시청연령을 선택해주세요")
	private String grade;
	
	private String image;
	
	private MultipartFile upload;
	
	private String upload_old;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload.getName():"+upload.getName()); 
		System.out.println("upload.getOriginalFilename():"+upload.getOriginalFilename()); 
		
		this.image = upload.getOriginalFilename();
		System.out.println(image == null);
		System.out.println(image.equals(""));
	}
	public String getUpload_old() {
		return upload_old;
	}
	public void setUpload_old(String upload_old) {
		this.upload_old = upload_old;
	}
	
}
