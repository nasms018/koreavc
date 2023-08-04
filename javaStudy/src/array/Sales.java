package array;

public class Sales {

	public static void main(String[] args) {
		int[][] sales = {
				{1, 2, 3, 4},
				{51, 52, 53, 54},
				{31, 32, 33, 34},
		};
		
		int sum = 0;
		//년별 매출 총액
		int[] salesAmountPerYear = new int[sales.length];
		//분기별 매출 총액
		int[] salesAmountPerQuarter = new int[sales[0].length];
		for (int y = 0; y < sales.length; y++)
			for (int quarter = 0; quarter < sales[y].length; quarter++) {
				sum += sales[y][quarter];
				salesAmountPerYear[y] += sales[y][quarter];
				salesAmountPerQuarter[quarter] += sales[y][quarter];
			}
		
		System.out.printf("%d년 매출 총액은 %d 이구요, 평균은 %.2f입니다.", sales.length, sum, (float) sum / sales.length);
	}

}
