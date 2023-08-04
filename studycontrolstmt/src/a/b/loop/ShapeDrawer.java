package a.b.loop;

public class ShapeDrawer {

	public static void main(String[] args) {
		drawRect();
		System.out.println();

		drawEmptyRect();
		System.out.println();

		drawTriangle();
		System.out.println();

		drawEmptyTriangle();
		System.out.println();

		drawInvertedTriangle();
		System.out.println();

		drawEmptyInvertedTriangle();
		System.out.println();
		
		drawEqTriangle();
		System.out.println();

		drawEmptyEqTriangle();
		System.out.println();
	}

	/**
	 * **********
	 * ********** 
	 * ********** 
	 * ********** 
	 * **********
	 */
	public static void drawRect() {
		final int ROWS = 5, COLS = 10;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	/**
	 * ********** 
	 * *........* 
	 * *........* 
	 * *........* 
	 * **********
	 */
	public static void drawEmptyRect() {
		final int ROWS = 5, COLS = 10;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) {
					// 사각형의 경계 위치입니까?
					System.out.print('*');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

	/**
	 * *1 
	 * **2 
	 * ***3 
	 * ********** 10
	 */
	public static void drawTriangle() {
		final int ROOT = 10;

		for (int r = 0; r < ROOT; r++) { // 0, 1, 2, ..., 9
			for (int c = 0; c <= r; c++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	/**
	 * *1 
	 * **2 
	 * *.*3 
	 * *..*4 
	 * *...*5 
	 * ********** 10
	 */
	public static void drawEmptyTriangle() {
		final int ROOT = 10;

		for (int r = 0; r < ROOT; r++) { // 0, 1, 2, ..., 9
			for (int c = 0; c <= r; c++) {
				if (r == 0 || r == ROOT - 1 || c == 0 || c == r) {
					// 삼각형의 경계 위치입니까?
					System.out.print('*');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

	/**
	 * ********** 10 
	 * ********* 9 
	 * ******** 8 
	 * *1
	 */
	public static void drawInvertedTriangle() {
		final int ROOT = 10;

		for (int r = 0; r < ROOT; r++) { // 0, 1, 2, ..., 9
			for (int c = r; c < ROOT; c++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	/**
	 * ********** 10 
	 * *.......* 9 
	 * *......* 8 
	 * **2 
	 * *1
	 */
	public static void drawEmptyInvertedTriangle() {
		final int ROOT = 10;

		for (int r = 0; r < ROOT; r++) { // 0, 1, 2, ..., 9
			for (int c = r; c < ROOT; c++) { // 0..9, 1..9, 2..9, ..., 9
				if (r == 0 || r == ROOT - 1 || c == r || c == ROOT - 1) {
					// 삼각형의 경계 위치입니까?
					System.out.print('*');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

	/**
	 * 2 * r - 1 = c
	 * 	      
	 *       ____*  4 1
	 *       ___*** 3 3
	 *       __***** 2 5
	 *       _******* 1 7
	 *       ********* 0 9
	 *        
	 */
	public static void drawEqTriangle() {
		final int ROWS = 3;

		for (int r = 0; r < ROWS; r++) {	//0, 1, 2, 3, 4
			for (int c = 0; c < ROWS + r; c++) {	//0..4, 0..5, 0..6, 0..7, 0..8
				if (c < ROWS - r - 1) {
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}

	/**
	 * 2 * r - 1 = c
	 * 	      
	 *       ____*  4 1
	 *       ___*.* 3 3
	 *       __*...* 2 5
	 *       _*.....* 1 7
	 *       ********* 0 9
	 *        
	 */
	public static void drawEmptyEqTriangle() {
		final int ROWS = 5;

		for (int r = 0; r < ROWS; r++) {	//0, 1, 2, 3, 4
			boolean isFirstStar = true;
			for (int c = 0; c < ROWS + r; c++) {	//0..4, 0..5, 0..6, 0..7, 0..8
				if (c < ROWS - r - 1) {
					System.out.print(' ');
				} else {
					if (isFirstStar || r == ROWS - 1 || c == ROWS + r - 1) {
						System.out.print('*');
					} else {
						System.out.print('.');
					}
					isFirstStar = false;
				}
			}
			System.out.println();
		}
	}
}
