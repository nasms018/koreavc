package a.b.swch;

import java.util.Scanner;

public class Calc {
	/**
	 * 3 + 8.5와 같은 산식을 입력하면 이를 분해하여 3, 8.5 및 +를 추출하고 
	 * 연산자에 따라 계산하고 이를 출력하는 프로그램입니다
	 * 연산자는 사칙연산자(+ - / *)를 지원합니다
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//항 두개 읽기
		float 앞항 = input.nextFloat();
		float 뒷항 = input.nextFloat();
		
		//연산자
		String 연산자 = input.next();
		float 결과 = 0.0f;
		// switch로 종류별 처리
		switch(연산자) {
		case "+":
			결과 = 앞항 + 뒷항;
			break;
		case "-":
			결과 = 앞항 - 뒷항;
			break;
		case "/":
			결과 = 앞항 / 뒷항;
			break;
		case "*":
			결과 = 앞항 * 뒷항;
			break;
		}
		//결과출력 
		System.out.println(결과);
	}

}
