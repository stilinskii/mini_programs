import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		System.out.println("값 2개를 입력해주세요.");
		
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		
		String[] splitedValue = inputValue.split(" ");
		
		int first = Integer.parseInt(splitedValue[0]);
		int second = Integer.parseInt(splitedValue[1]);
		
		
		System.out.println("두 수의 합은 "+ (first + second)+"입니다.");
	}

}
