import java.util.Scanner;

public class Calendar {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}
	
	public static void main(String[] args) {
		System.out.println("달을 입력해 주세요");
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = scanner.nextInt();
		
		
		System.out.printf("%d월의 마지막일은 %d일입니다.\n",month,cal.getmaxDaysOfMonth(month));
		scanner.close();
		
	
	}
}
