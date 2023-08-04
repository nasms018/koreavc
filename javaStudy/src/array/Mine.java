package array;

import java.util.Scanner;

public class Mine {

	public static void main(String[] args) {
		final int ROOT = 10;
		char[][] board = new char[ROOT][ROOT];
		fillBoardWithMine(ROOT, board);
		Scanner scan = new Scanner(System.in);
		DO_LOOP:
		do {
			displayBoard(ROOT, board);
			//사용자 선택 받기  'X'
			System.out.print("좌표입력 :");
			int userRow = scan.nextInt();
			int userCol = scan.nextInt();
			if (outOfBound(ROOT, userRow, userCol)) {
				System.out.println("잘못된 좌표");
				continue;
			}
			if (hasMine(board, userRow, userCol)) {
				//지뢰밟았으면
				System.out.println("지뢰 찾기 실패");
				break DO_LOOP;
			}
			int mineCountAroundMe = 0;
			for (방향8 방향 : 방향8.values()) {
				int provingRow = userRow + 방향.getRowDelta();
				int provingCol= userCol + 방향.getColDelta();
				if (outOfBound(ROOT, provingRow, provingCol)) {
					continue;
				}
				if (hasMine(board, provingRow, provingCol)) {
					mineCountAroundMe++;
				}
			}
			board[userRow][userCol] = (char) ('0' + mineCountAroundMe);
			
		} while (true);
	}
	private static boolean hasMine(char[][] board, int userRow, int userCol) {
		return board[userRow][userCol] == '#';
	}
	private static boolean outOfBound(final int ROOT, int userRow, int userCol) {
		return userRow < 0 || userRow >= ROOT
				|| userCol < 0 || userCol >= ROOT;
	}
	private static void displayBoard(final int ROOT, char[][] board) {
		for (int r = 0; r < ROOT; r++) {
			for (int c = 0; c < ROOT; c++) {
				if (board[r][c] != 0) {
					System.out.print(board[r][c] + " ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	private static void fillBoardWithMine(final int ROOT, char[][] board) {
		for (int r = 0; r < ROOT; r++) {
			for (int c = 0; c < ROOT; c++) {
				if (Math.random() < 0.2)
					board[r][c] = '#';
			}
		}
	}
}
