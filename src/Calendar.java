import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public static void main(String[] args) {
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			} else if (month > 12) {
				continue;
			} else {
				System.out.printf("%d월의 마지막일은 %d일입니다.\n", month, cal.getmaxDaysOfMonth(month));
			}

		}

		System.out.println("끝");

		scanner.close();

	}
}
