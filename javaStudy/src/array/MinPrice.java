package array;

public class MinPrice {

	public static void main(String[] args) {
		int[] prices = {98, 65, 76755, 4334, 8778, -8787};
		int minPrice = Integer.MAX_VALUE;
		boolean isFirst = true; 
		for (int price : prices) {
			if (isFirst) {
				isFirst = false;
				minPrice = price;
			}
			if (price < minPrice) {
				minPrice = price;
			}
		}
		System.out.println(minPrice);
	}

}
