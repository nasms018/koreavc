package array;

public enum CellStatus {
	빈칸((char)0), 사용자가놓은('X'), 컴퓨터가놓은('O');
	private char stone;
	
	private CellStatus(char stone) {
		this.stone = stone;
	}

	public char getStone() {
		return stone;
	}
	
}
