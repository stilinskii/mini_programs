package review_application;

import java.util.Date;

public class Backend_class extends Review {
	private String type = "백엔드";
	
	public Backend_class() {
	}

	public Backend_class(String class_name, String id, String teacher, String comment,Date time) {
		super(class_name,id,teacher,comment,time);
	}
	
	@Override
	public String toString() {
		
		return "수업과정 : 백엔드\n"+super.toString();
	}
}
