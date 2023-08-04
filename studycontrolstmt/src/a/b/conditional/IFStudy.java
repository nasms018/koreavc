package a.b.conditional;

import java.util.Scanner;

public class IFStudy {

	public static void main(String[] args) {
		// 사용자의 입력을 정수로 받고
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 입력하세요:");
		int number = input.nextInt();
		// 양수인지 아닌지를 echo하는 프로그램
		if (number > 0) {
			System.out.println("positive수");
		} else {
			System.out.println("non positive수");
		}
	}

}
