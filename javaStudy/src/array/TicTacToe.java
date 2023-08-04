package array;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		final int ROOT = 3;
		Scanner scan = new Scanner(System.in);
		//보드 만들기
		char[][] board = new char[ROOT][ROOT];
		//끝날때까지 반복
		do {
			//상황 출력
			displayBoard(ROOT, board);
			//사용자 선택 받기  'X'
			System.out.print("좌표입력 :");
			int userRow = scan.nextInt();
			int userCol = scan.nextInt();
			if (userRow < 0 || userRow >= ROOT
					|| userCol < 0 || userCol >= ROOT
					|| board[userRow][userCol] != 0) {
				System.out.println("잘못된 좌표");
				continue;
			}
			board[userRow][userCol] = 'X';
			//첫 빈칸에 컴퓨터 선택 'O'
			int row, col = 0;
			OUTER_FOR:
			for (row = 0; row < ROOT; row++) {
				for (col = 0; col < ROOT; col++) {
					if (board[row][col] == 0) {
						board[row][col] = 'O';
						break OUTER_FOR;
					}
				}
			}
			
			//빈칸이 없으면 종료
			if (row == ROOT && col == ROOT)
				break;
		} while (true);
	}

	private static void displayBoard(final int ROOT, char[][] board) {
		boolean isFirstRow = true;
		for (int row = 0; row < ROOT; row++) {
			if (isFirstRow) {
				isFirstRow = false;
			} else {
				for (int col = 0; col < ROOT; col++) {
					System.out.print("---|");
				}
				System.out.println();	
			}
			
			boolean isFirstCol = true;
			for (int col = 0; col < ROOT; col++) {
				if (isFirstCol) {
					isFirstCol = false;
				} else {
					System.out.print('|');
				}
				System.out.printf(" %c ", board[row][col]);	
			}
			System.out.println();	
		}
	}

}
