package array;

public enum 방향8 {
	동(0, 1), 서(0, -1), 남(1, 0), 북(-1, 0), NE(-1, 1), SE(1, 1), SW(1, -1), NW(-1, -1);
	
	private int rowDelta, colDelta;
	
	private 방향8(int rowDelta, int colDelta) {
		this.rowDelta = rowDelta;
		this.colDelta = colDelta;
	}

	public int getRowDelta() {
		return rowDelta;
	}

	public int getColDelta() {
		return colDelta;
	}
}
