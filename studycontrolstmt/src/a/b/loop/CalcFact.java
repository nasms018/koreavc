package a.b.loop;

import java.util.Scanner;

public class CalcFact {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int target = input.nextInt();
		long fact = 1;
		for (int i = target; i > 1; i--) {
			fact *= i;
		}
		System.out.printf("%d까지의 곱은 %d입니다.", target, fact);
	}

}
