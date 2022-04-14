package review_application;

abstract class Review {
	
	String class_name;
	String id;
	String comment;
	String teacher;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String class_name, String id,  String teacher,String comment) {
		this.class_name = class_name;
		this.id = id;
		this.comment = comment;
		this.teacher = teacher;
	}
	
	
	public String toString() {
		return String.format("수업명 : %s\n강사 : %s\n후기 : %s\n\n", class_name,teacher,comment);
	}
	
	
	
}
