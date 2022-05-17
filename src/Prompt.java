import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Prompt {
	String PROMPT = "> ";
	Scanner scanner = new Scanner(System.in);
	Calendar cal = new Calendar();
	
	List<Map<String, String>> planList = new ArrayList<>();
	
	
	

	public String menu() {
		return "+----------------------+\r\n" + "| 1. 일정 등록           \r\n" + "| 2. 일정 검색           \r\n"
				+ "| 3. 달력 보기\r\n" + "| h. 도움말 q. 종료\r\n" + "+----------------------+\r\n" + "명령 (1, 2, 3, h, q)";
	}

//int면 값 숫자로 변환해서 리턴, 아니면 0리턴
	public static int StringOrInt(String s) {
		try {
			Integer.parseInt(s);
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public void runPrompt() {

		while (true) {
			System.out.println(menu());
			System.out.print(PROMPT);
			String choice = scanner.next();
			int choiceChk = StringOrInt(choice);

			if (choiceChk > 0 && choiceChk < 4) {
				switch (choiceChk) {
				case 1:
					createPlan();
					break;
				case 2:
					searchPlan();
					break;
				case 3:
					viewCalendar();
					break;
				}
			} else if (choiceChk == 0) {
				switch (choice) {
				case "h":
					help();
					break;
				case "q":
					System.out.println("끝");
					return;
				}
			} else {
				System.out.println("입력값을 확인해주세요.");
			}

		}

	}

	private void viewCalendar() {
		// TODO Auto-generated method stub

		while (true) {

			System.out.println("년도를 입력하세요");
			System.out.print(PROMPT);
			int year = scanner.nextInt();
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			} else if (month > 12 || month <= 0) {
				continue;
			} else {
				cal.printCalendar(year, month);

			}

			while (true) {

				System.out.println("메인으로 돌아갈까요?(y/n)");
				System.out.print(PROMPT);
				String choice = scanner.next();
				if (choice.equals("y")) {
					return;
				} else if(choice.equals("n")) {
					break;
				}else {
					System.out.println("input [y] or [n]");
				}

			}

		}

	}

	private void searchPlan() {
		// TODO Auto-generated method stub
		
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.print(PROMPT);
		String date = scanner.nextLine();
		System.out.println("개의 일정이 있습니다.");
		System.out.print(PROMPT);
		String plan = scanner.nextLine();
		
		//planList.put(date, plan);
		
		System.out.println("일정이 등록되었습니다.");

	}

	private void createPlan() {
		// TODO Auto-generated method stub
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print(PROMPT);
		String date = scanner.nextLine();
		System.out.println("일정을 입력하세요.");
		System.out.print(PROMPT);
		String plan = scanner.nextLine();
		
		Map<String,String> store = new HashMap<>();
		store.put(date, plan);
		planList.add(store);
		
		System.out.println("일정이 등록되었습니다.");
		
		
	}

	private void help() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
