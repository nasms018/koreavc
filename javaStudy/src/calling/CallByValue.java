package calling;

public class CallByValue {

	public static void main(String[] args) {
		int[] x = {8, 10};
		aFunc(x);
		System.out.println(x[0]);
	}

	public static void aFunc(int[] p) {
		p[0] = 999;
	}
}
