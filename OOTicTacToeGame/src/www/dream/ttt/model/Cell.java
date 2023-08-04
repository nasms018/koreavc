package www.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.ttt.model.domain.StoneType;

public class Cell {
	//전역 변수
	protected static int numberOfCellCreated = 0;
	
	private List<Line> 너가담긴라인목록 = new ArrayList<>();
	private StoneType depositedStone = StoneType.Empty; //놓인돌

	protected Cell() {
		numberOfCellCreated++;
	}
	
	public void 너는라인에담겨있다라고기억해라(Line line) {
		너가담긴라인목록.add(line);
	}

	public StoneType 돌줘() {
		return depositedStone;
	}

	public void 돌놓을께(StoneType myStone) {
		depositedStone = myStone;
	}

	public boolean 빈상태니() {
		return depositedStone == StoneType.Empty;
	}

	public int getScore() {
		int totScore = 0;
		for (Line line : 너가담긴라인목록) {
			totScore += line.getScore();
		}
		return totScore;
	}

}
