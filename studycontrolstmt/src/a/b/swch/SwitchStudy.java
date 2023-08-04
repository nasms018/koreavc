package a.b.swch;

import java.util.Scanner;

public class SwitchStudy {
	/**
	 * 1, 2를 입력, 하나, 둘 출력
	 * 기본은 몰라
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int aNum = input.nextInt();

		switch(aNum) {
		case 1:
			System.out.println("하나");
			break;
		case 2:
			System.out.println("둘");
			break;
		default:
			System.out.println("몰라");
			break;
		}
	}

}
