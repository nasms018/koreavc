package www.dream.array;

public class RandomWork {

	public static void main(String[] args) {
		final int ROOT = 11;
		boolean[][] visited = new boolean[ROOT][ROOT];
		
		int curRow = ROOT / 2, curCol = ROOT / 2;
		visited[curRow][curCol] = true;
		
		final int TOT_STEPS = ROOT * ROOT / 4; //총걸음수
		int steps = 0;
		for (; steps < TOT_STEPS; steps++) {
			//갈 방향 4종류로 임의 생성. N0, E1, S, W3
			int direction = (int) (Math.random() * 4); 
			if (curRow > 0 && direction == 0) {
				curRow--;
			} else if (curCol < ROOT - 1 && direction == 1) {
				curCol++;
			} else if (curRow < ROOT - 1 && direction == 2) {
				curRow++;
			} else if (curCol > 0) {
				curCol--;
			}
			visited[curRow][curCol] = true;
			displayBoard(visited);
		}
	}

	/**
	 * 방문 경로 출력
	 * @param visited
	 */
	private static void displayBoard(boolean[][] visited) {
		for (boolean[] aRow: visited) {
			for (boolean v : aRow) {
				if (v) {
					System.out.print("# ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}

}
