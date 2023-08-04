package www.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.ttt.player.Player;

public class Board {
	/* 상수 정의 : private static final  */
	private static final int ROOT = 3;
    private static final Board INSTANCE = new Board();

    private Cell[][] cells = new Cell[ROOT][ROOT];
	private List<Line> listLine = new ArrayList<>();
	private List<Cell> listEmptyCell = new ArrayList<>();

	public static Board getInstance() {
        return INSTANCE;
    }
    
	/** 생성자. counstructor
	 * 생성시에 처리하여야 할 기능들을 작성
	 * 칸과 줄을 만들고 둘 사이의 관계 정보까지 설정한다.
	 */
    private Board() {
		//Cell 반복적 만들기
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				cells[row][col] = new Cell();
				listEmptyCell.add(cells[row][col]);
			}
		}
		//가로 Line 만들기
		for (int row = 0; row < ROOT; row++) {
			Line horizontalLine = new Line();
			for (int col = 0; col < ROOT; col++) {
				//Line아 Cell 받아라
				horizontalLine.칸담아라(cells[row][col]);
			}
			listLine.add(horizontalLine);
		}
		//세로 Line 만들기
		for (int col = 0; col < ROOT; col++) {
			Line verticalLine = new Line();
			for (int row = 0; row < ROOT; row++) {
				//Line아 Cell 받아라
				verticalLine.칸담아라(cells[row][col]);
			}
			listLine.add(verticalLine);
		}
		//정대각선 만들기. 00, 11, 22
		Line 정대각선 = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			//Line아 Cell 받아라
			정대각선.칸담아라(cells[idx][idx]);
		}
		listLine.add(정대각선);
		//역대각선 만들기. 02, 11, 20
		Line 역대각선 = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			//Line아 Cell 받아라
			역대각선.칸담아라(cells[idx][ROOT - idx - 1]);
		}
		listLine.add(역대각선);
		
		System.out.println(Cell.numberOfCellCreated);
	}

	/**
	 * 상황 출력
	 */
	public void display() {
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				System.out.print(cells[row][col].돌줘().getDisplayChar());
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

	public Cell getEmptyCell(int row, int col) {
		if (row < 0 || row >= ROOT)
			return null;
		if (col < 0 || col >= ROOT)
			return null;
		if (cells[row][col].빈상태니())
			return cells[row][col];
		System.out.println("놓인곳을 선택한 잘못");
		return null;
		
	}

	public List<Cell> getAllEmptyCell() {
		return listEmptyCell;
	}

	public void 빈칸목록에서지워라(Cell chosenCell) {
		listEmptyCell.remove(chosenCell);		
	}

	public boolean 계속할까(Player curPlayer) {
		줄평가해();
		for (Line line : listLine) {
			if (line.다채워졌니()) {
				System.out.println(curPlayer + "승리를 축하!!!");
				return false;
			}
		}

		if (listLine.size() == 0) {
			System.out.println("더 해도 승리 할 수 없어요!");
			return false;
		} else {
			//가치있는 줄이 있을 때 계속할 수 있다.
			return true;
		}
	}

	/**
	 * 병행 프로그램 및 조사 대상 축소까지 처리하여 성능 향상.
	 */
	private void 줄평가해() {
		List<Line> listUselessLine = new ArrayList<>();
		//lambda 함수형 프로그램.
		listLine.parallelStream().forEach(line -> {
			line.evaluate();
			if (line.getScore() == 0) {
				listUselessLine.add(line);
			}
		});
		
		listLine.removeAll(listUselessLine);
	}
}
