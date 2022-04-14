package review_application;

public class Backend_class extends Review {
	private String type = "백엔드";
	
	public Backend_class() {
	}

	public Backend_class(String class_name, String id, String teacher, String comment) {
		super(class_name,id,teacher,comment);
	}
}
