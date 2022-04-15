package review_application;

import java.util.Date;

public class Frontend_class extends Review{
	private String type = "프론트앤드";
	
	
	public Frontend_class() {
	}
	public Frontend_class(String class_name,String id,String teacher,String comment, Date time) {
		super(class_name,id,teacher,comment,time);
	}

	@Override
	public String toString() {
		
		return "수업과정 : 프론트\n"+super.toString();
	}
}
