package www.dream.ttt.player;

import java.util.List;

import www.dream.ttt.model.Board;
import www.dream.ttt.model.Cell;
import www.dream.ttt.model.domain.StoneType;

public class Player {
	private String name;
	protected StoneType myStone;
	
	public Player(String name) {
		this.name = name;
		this.myStone = StoneType.Black;
	}

	public void 너마음에드는칸에돌놓아라() {
		List<Cell> listEmptyCell = Board.getInstance().getAllEmptyCell();
		Cell best = listEmptyCell.get(0);
		int bestScore = best.getScore();
		for (int i = 1; i < listEmptyCell.size(); i++) {
			Cell empty = listEmptyCell.get(i);
			int score = empty.getScore();
			if (score > bestScore) {
				best = empty;
				bestScore = score;
			}
		}
		best.돌놓을께(myStone);
		Board.getInstance().빈칸목록에서지워라(best);
	}

	@Override
	public String toString() {
		return name;
	}
}
