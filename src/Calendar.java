import java.util.Scanner;

public class Calendar {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		System.out.println("반복횟수를 입력하세요.");
		int loopcount = scanner.nextInt();
		
		for(int i = 0; i < loopcount; i++) {
			System.out.println("월을 입력하세요");
			int month = scanner.nextInt();
			System.out.printf("%d월의 마지막일은 %d일입니다.\n",month,cal.getmaxDaysOfMonth(month));
		}
		
		System.out.println("끝");
		
		
		scanner.close();
		
	
	}
}
