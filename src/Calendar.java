import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("달을 입력해 주세요");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int monthdays = maxDays[month - 1];
		
		System.out.printf("%d월의 마지막일은 %d일입니다.",month,monthdays);
		scanner.close();
		
	
	}
}
