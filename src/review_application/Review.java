package review_application;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Review {
	
	String class_name;
	String id;
	String comment;
	String teacher;
	Date time;
	
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
		return String.format("수업명 : %s\n강사 : %s\n후기 : %s\n입력날짜 : %s", class_name,teacher,comment,format.format(time));
	}
	
	
	
}
