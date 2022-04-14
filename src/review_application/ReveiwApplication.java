package review_application;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReveiwApplication {
	private static Scanner sc = new Scanner(System.in);
	static ArrayList<Review> review = new ArrayList<>();

	public static void main(String[] args) {
		
	//	System.out.println(LocalTime);
		LocalDateTime d = LocalDateTime.now();
		
		
		System.out.println(d.format(DateTimeFormatter.ofPattern("오늘은 yyyy년 MM월 dd일, 현재시각은 HH시 mm분입니다.")));
		System.out.println("1. 후기입력 2. 후기들조회 3. 후기삭제 4. 후기수정 5.종료");
		
	label:while(true) {
			System.out.println("하고싶은 것을 선택하세요.");
			int num = sc.nextInt();
			switch (num) {
			case 1: inputReview();break;
			case 2: viewReview();break;
			case 3: delReview();break;
			case 4: editReview();break;
			case 5: break label;
			default: System.out.println("잘못된 값");
			}
		}
		
		
	}
	
//	실행결과
//
//	후기남긴 날짜 시간:  2022 년 4월 10일
//	수업종류:
//	수업명 : 자바웹개발
//	강사: 임하영
//	후기: 좋았다
	
	public static void inputReview() {

		
		System.out.print("아이디 :");
		String id = sc.next();
		System.out.print("수업종류(프론트: f, 백엔드:b) :");
		String type = sc.next();
		System.out.print("수업명 :");
		sc.nextLine();
		String class_name = sc.next();
		System.out.print("강사 :");
		String teacher = sc.next();
		System.out.print("후기 :");
		String comment = sc.next();
		
		
		if(type.equals("f")) {
			Frontend_class f1 = new Frontend_class(class_name,id,teacher,comment);
			review.add(f1);
			
		}else if(type.equals("b")) {
			Backend_class b1 = new Backend_class(class_name,id,teacher,comment);
			review.add(b1);
		}
	}

	public static void viewReview() {
		//날짜
		for(Review data: review) {
			System.out.println(data.toString());
		}
		
	}
	public static void delReview() {
		
	}
	public static void editReview() {
		
	}
	
	
}
