import java.time.DayOfWeek;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public static void main(String[] args) {
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		
		

		while (true) {
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			} else if (month > 12 || month <= 0) {
				continue;
			} else {
				printCalendar(2022,month);
				
			}
		}

			System.out.println("끝");

			scanner.close();

		
	}
	
	public static void printCalendar(int year, int month) {
		int maxDayOfMonth = getmaxDaysOfMonth(month);
		System.out.printf("%d월의 마지막일은 %d일입니다.\n", month, maxDayOfMonth);
		System.out.printf("     <%d년 %d월>\n",year, month);
		System.out.println(" SU MO TU WE TU FR SA");
		System.out.println("----------------------");
		for (int i = 1; i <= maxDayOfMonth; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
}
