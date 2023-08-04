package a.b.BreakContinue;

import java.util.Scanner;

public class NumGuess {

	public static void main(String[] args) {
		// 1~100 정답 만들기
		double rn = Math.random();	//0.00000 ~ ex 1.000000
		int answer = (int) (rn * 100) + 1;
		
		int tryCount = 0;	//시도횟수
		
		//입력장치 필요
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("추측값 입력 :");
			//사용자의 추측
			int userGuess = input.nextInt();
			tryCount++;
			//정답 비교하여 큰, 작, 같
			if (userGuess > answer) {
				System.out.println("제시한 정수가 높습니다.");
			} else if (userGuess < answer) {
				System.out.println("제시한 정수가 낮습니다.");
			} else {
				break;
			}
		} while(true);	//못하면 시도횟수올리고 추측 또 받기

		//시도횟수 출력
		System.out.printf("시도횟수는 %d회입니다", tryCount);
	}

}
