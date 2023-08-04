package array;

import java.util.Scanner;

public class SeatReservation {
	static final int TOTAL_SEATS = 10;
	static final int END_CHOICE = 0;

	public static void main(String[] args) {
		int[] seatReservState = new int[TOTAL_SEATS];
		Scanner inDevice = new Scanner(System.in);
		do {
			guideMessage(seatReservState);
			//선택 받기
			int userChoice = inDevice.nextInt();
			if (userChoice == END_CHOICE) {
				break;
			}
			//좌석 예약 상태에 따라
			if (seatReservState[userChoice - 1] == 0) {
				seatReservState[userChoice - 1] = 1;
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("이미 예약된 자리입니다.");
			}
		} while (true);
	}

	private static void guideMessage(int[] seatReservState) {
		//좌석 안내
		for (int i = 1; i <= TOTAL_SEATS; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//상황 안내
		for (int rs : seatReservState) {
			System.out.print(rs + "\t");
		}
		System.out.println();

		//선택 안내
		System.out.printf("원하시는 좌석 번호를 입력하세요(종료는 %d) : ", END_CHOICE);
	}
}
