package review_application;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Review {
	
	private String class_name;
	private String id;
	private String comment;
	private String teacher;
	private Date time;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String class_name, String id,  String teacher,String comment, Date time) {
		this.class_name = class_name;
		this.id = id;
		this.comment = comment;
		this.teacher = teacher;
		this.time = time;
	}
	
	
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 mm분");
		return String.format("수업명 : %s\n강사 : %s\n후기 : %s\n입력날짜 : %s\n", class_name,teacher,comment,format.format(time));
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
