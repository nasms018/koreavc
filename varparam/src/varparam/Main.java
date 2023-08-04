package varparam;

public class Main {
	public static int sum(int a, int... b) {
		for (int v : b)
			a += v;
		return a;
	}

	public static void main(String[] args) {
		System.out.println(sum(5));
		System.out.println(sum(5, 6));
		System.out.println(sum(5, 6, 7));
		System.out.println(sum(5, 6, 7, 8, 9));
	}

}
