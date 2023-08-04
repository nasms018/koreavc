package array;

public class DiceFreq {

	public static void main(String[] args) {
		//주사위를 1만번 던졌을 때 각 면이 몇 번 나왔는지를 표 형식으로 출력하기
		/* 주석 블록
		 * =========================
		 * 면	빈도
		 * =========================
		 * 1	1690
		 * 6	1678
		 */
		final int NUMBER_OF_CASES = 6;	//경우의수
		//random 1 ~ 6
		//빈도[]
		int[] 빈도 = new int[NUMBER_OF_CASES];
		
		for (int i = 0; i < 10000; i++) {
			빈도[(int) (Math.random() * NUMBER_OF_CASES)]++;
		}
		
		//표 형식으로 출력하기
		System.out.println("=========================");
		System.out.println("면	빈도");
		System.out.println("=========================");
		for (int i = 1; i <= NUMBER_OF_CASES; i++) {
			System.out.printf("%d\t%d\n", i, 빈도[i - 1]);
		}
	}

}
