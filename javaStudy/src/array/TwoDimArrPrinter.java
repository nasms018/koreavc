package array;

public class TwoDimArrPrinter {

	public static void main(String[] args) {
		char[][] data = {
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h'},
				{'i', 'j', 'k', 'l'}
			};
		boolean[][] visited = new boolean[data.length][data[0].length];
		//시계돌리기 00 01 02 03 04 13 23
		방향[] 시계방향으로돌기 = {방향.동, 방향.남, 방향.서, 방향.북};
		int curRowIdx = 0, curColIdx = -1, 현재방향Idx = 0;
		방향 현재방향 = 시계방향으로돌기[현재방향Idx];
		while (true) {
			int nextRowIdx = curRowIdx + 현재방향.getRowDelta();
			int nextColIdx = curColIdx + 현재방향.getColDelta();
			//안전하게 갈수 있나?
			if (nextRowIdx < data.length && nextRowIdx >= 0
					&& nextColIdx < data[0].length && nextColIdx >= 0
					) {
				if (visited[nextRowIdx][nextColIdx]) {
					break;
				}
				visited[nextRowIdx][nextColIdx] = true;
				System.out.print(data[nextRowIdx][nextColIdx]);
				curRowIdx = nextRowIdx;
				curColIdx = nextColIdx; 
			} else {
				현재방향Idx++;
				if (현재방향Idx >= 시계방향으로돌기.length) {
					현재방향Idx = 0;
				}
				현재방향 = 시계방향으로돌기[현재방향Idx];
			}
		}
		
	}

}
