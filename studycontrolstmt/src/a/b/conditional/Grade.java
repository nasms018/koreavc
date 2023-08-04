package a.b.conditional;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("성적을 입력하세요:");
		int score = input.nextInt();
		char grade = 'F';
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		}
		System.out.println(grade + "등급입니다.");
	}

}
