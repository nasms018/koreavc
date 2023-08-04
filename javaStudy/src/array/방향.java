package array;

public enum 방향 {
	동(0, 1), 서(0, -1), 남(1, 0), 북(-1, 0);
	
	private int rowDelta, colDelta;
	
	private 방향(int rowDelta, int colDelta) {
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
