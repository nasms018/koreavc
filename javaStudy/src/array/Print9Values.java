package array;

public class Print9Values {

	public static void main(String[] args) {
		//0, 1, 2, ..., 9
		int[] values = new int[10];
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}

		boolean needComma = false;
		for (int i = 0; i < values.length; i++) {
			if (needComma) {
				System.out.print(", ");
			}
			System.out.print(values[i]);
			needComma = true;
		}
	}

}
