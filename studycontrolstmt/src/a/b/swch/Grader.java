package a.b.swch;

import java.util.Scanner;

public class Grader {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int score = input.nextInt();	//0~100 값만 허용
		int sByTen = score / 10;
		char grade = 'F';
		switch(sByTen) {
		case 10:case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		}
		System.out.println(grade + "입니다");
	}

}
