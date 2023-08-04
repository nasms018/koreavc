package a.b.loop;

import java.util.Scanner;

public class GuGu {

	public static void main(String[] args) {
		// 목표 단 선택
		Scanner input = new Scanner(System.in);
		int 목표단;		//2~9
		do {
			System.out.print("외우고 싶은 단을 입력하세요 : ");
			목표단 = input.nextInt();
		} while (목표단 < 2 || 목표단 > 9);
		
		// 1~9 for반복
		for (int i = 1; i < 10; i++) {
			System.out.println(목표단 + " * " + i + " = " + (목표단 * i));
		}

	}

}
