import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		int a,b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("두 수 입력");
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		System.out.println("두 수의 합은" + (a+b));
		System.out.printf("%d와 %d의 합은 %d입니다.",a,b,a+b);
		scanner.close();
	}

}
