package array;

public class Cell {
	int row, col;
	CellStatus stone;
	
	public Cell(int row, int col, CellStatus st) {
		super();
		this.row = row;
		this.col = col;
		stone = st;
	}

	public CellStatus getStoneStatus() {
		return stone;
	}

	/**
	 * 비어있니
	 * @return
	 */
	public boolean isEmpty() {
		return stone == CellStatus.빈칸;
	}

	/**
	 * 돌놓을께
	 * @param 사용자가놓은
	 */
	public void setStone(CellStatus 사용자가놓은) {
		this.stone = 사용자가놓은;
	}

	/**
	 * 이돌이놓여있니
	 * @param 사용자가놓은
	 * @return
	 */
	public boolean isSameStone(CellStatus 사용자가놓은) {
		return stone == 사용자가놓은;
	}
	
	
}
