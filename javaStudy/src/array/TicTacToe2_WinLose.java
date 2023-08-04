package array;

import java.util.Scanner;

public class TicTacToe2_WinLose {

	public static void main(String[] args) {
		final int ROOT = 3;
		Scanner scan = new Scanner(System.in);
		//보드 만들기
		Cell[][] board = new Cell[ROOT][ROOT];
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				Cell cell = new Cell(row, col, CellStatus.빈칸);
				board[row][col] = cell;
			}
		}

		Line[] lines = buildLines(ROOT, board);
		
		//끝날때까지 반복
		DO_LOOP:
		do {
			//상황 출력
			displayBoard(ROOT, board);
			
			//사용자 선택 받기  'X'
			System.out.print("좌표입력 :");
			int userRow = scan.nextInt();
			int userCol = scan.nextInt();
			if (userRow < 0 || userRow >= ROOT
					|| userCol < 0 || userCol >= ROOT
					|| !(board[userRow][userCol].isEmpty())) {
				System.out.println("잘못된 좌표");
				continue;
			}
			board[userRow][userCol].setStone(CellStatus.사용자가놓은);
			//어떤 줄에 같은 돌이 놓였으면 승부가 났다. 사용자 승리
			for (Line line : lines) {
				if (line.isFilledWithSameStone(CellStatus.사용자가놓은)) {
					System.out.println("승리를 축하!!");
					break DO_LOOP;
				}
			}
			//첫 빈칸에 컴퓨터 선택 'O'
			int row, col = 0;
			OUTER_FOR:
			for (row = 0; row < ROOT; row++) {
				for (col = 0; col < ROOT; col++) {
					if (board[row][col].isEmpty()) {
						board[row][col].setStone(CellStatus.컴퓨터가놓은);
						break OUTER_FOR;
					}
				}
			}
			
			//빈칸이 없으면 종료
			if (row == ROOT && col == ROOT)
				break;
		} while (true);
	}

	/**
	 * 줄 만들기
	 * 가로, 세로, 두개의 대각줄
	 * @param ROOT
	 * @param board
	 */
	private static Line[] buildLines(final int ROOT, Cell[][] board) {
		Line[] lines = new Line[2 * ROOT + 2];
		//가로줄
		int lineIdx = 0;
		//-45, 45 대각줄
		Line line_135 = new Line();
		Line line_45 = new Line();
		for (int row = 0; row < ROOT; row++) {
			line_135.addCell(board[row][row]);
			line_45.addCell(board[ROOT - row - 1][row]);
			Line line = new Line();
			for (int col = 0; col < ROOT; col++) {
				line.addCell(board[row][col]);
			}
			lines[lineIdx++] = line;
		}
		lines[lineIdx++] = line_135;
		lines[lineIdx++] = line_45;
		
		//세로줄
		for (int col = 0; col < ROOT; col++) {
			Line line = new Line();
			for (int row = 0; row < ROOT; row++) {
				line.addCell(board[row][col]);
			}
			lines[lineIdx++] = line;
		}
		return lines;
	}

	private static void displayBoard(final int ROOT, Cell[][] board) {
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
				System.out.printf(" %c ", board[row][col].getStoneStatus().getStone());	
			}
			System.out.println();	
		}
	}

}
