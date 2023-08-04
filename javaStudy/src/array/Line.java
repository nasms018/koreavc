package array;

import java.util.ArrayList;
import java.util.List;

public class Line {
	//한줄의
	List<Cell> cells = new ArrayList<>();

	/**
	 * 칸받아라
	 * @param cell
	 */
	public void addCell(Cell cell) {
		cells.add(cell);
	}

	/**
	 * 같은돌로채워졌니
	 * @param 사용자가놓은
	 * @return
	 */
	public boolean isFilledWithSameStone(CellStatus 사용자가놓은) {
		for (Cell cell : cells) {
			if (! cell.isSameStone(사용자가놓은)) {
				return false;
			}
		}
		return true;
	}
}
