package category.detail;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Range;

public class DetailBean {
	
	private int num;
	private int vnum;
	private String title;
	@NotBlank(message = "줄거리를 입력해주세요")
	private String content;
	@Null(message = "줄거리를 입력해주세요")
	private int runningT;
	@NotBlank(message = "장르를 입력해주세요")
	private String genre;
	@NotBlank(message = "제작국가를 입력해주세요")
	private String nation;
	@NotBlank(message = "출연배우를 입력해주세요")
	private String actor;
	private String grade;
	@NotBlank(message = "방영일을 입력해주세요")
	private String day;
	@Null(message = "줄거리를 입력해주세요")
	private int series;
	private String video;	
	private String image;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getVnum() {
		return vnum;
	}
	public void setVnum(int vnum) {
		this.vnum = vnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRunningT() {
		return runningT;
	}
	public void setRunningT(int runningT) {
		this.runningT = runningT;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
