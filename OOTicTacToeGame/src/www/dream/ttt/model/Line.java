package www.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.ttt.model.domain.StoneType;

public class Line {
	private List<Cell> listCell = new ArrayList<>();
	private int score = 1;

	public void 칸담아라(Cell cell) {
		listCell.add(cell);
		cell.너는라인에담겨있다라고기억해라(this);
	}

	/**
	 * ... : 1
	 * X.., .X., ..X : 5
	 * O.., .O., ..O : 3
	 * XX., X.X, .XX : 100
	 * OO., O.O, .OO : 80
	 * OX., XO., O.X...... : 0
	 */
	public void evaluate() {
		int[] stoneStatus = new int[StoneType.values().length];

		for (Cell cell : listCell) {
			stoneStatus[cell.돌줘().ordinal()]++;
		}
		
		if (stoneStatus[StoneType.Empty.ordinal()] == 3) {
			score = 1;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 2 
				&& stoneStatus[StoneType.Black.ordinal()] == 1) {
			score = 5;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 2 
				&& stoneStatus[StoneType.White.ordinal()] == 1) {
			score = 3;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 1 
				&& stoneStatus[StoneType.Black.ordinal()] == 2) {
			score = 100;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 1 
				&& stoneStatus[StoneType.White.ordinal()] == 2) {
			score = 80;
		} else if (stoneStatus[StoneType.Black.ordinal()] == 3
				|| stoneStatus[StoneType.White.ordinal()] == 3) {
			score = 1000;
		} else {
			score = 0;
		}
	}

	public int getScore() {
		return score;
	}

	public boolean 다채워졌니() {
		return score == 1000;
	}

}
