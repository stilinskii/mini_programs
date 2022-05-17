import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

		
	
	public void printCalendar(int year, int month) {
		int maxDayOfMonth = getmaxDaysOfMonth(month);
		System.out.printf("%d월의 마지막일은 %d일입니다.\n", month, maxDayOfMonth);
		System.out.printf("     <%d년 %d월>\n",year, month);
		System.out.println(" SU MO TU WE TU FR SA");
		System.out.println("----------------------");
		
		int inputDayOfWeek = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
		for(int i =0;i<inputDayOfWeek;i++) {
			if(inputDayOfWeek==7)
				break;
				System.out.print("   ");
		}
		
		for (int i = 1; i <= maxDayOfMonth; i++) {
			System.out.printf("%3d", i);
			if (LocalDate.of(year, month, i).getDayOfWeek().getValue() % 6==0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
}
