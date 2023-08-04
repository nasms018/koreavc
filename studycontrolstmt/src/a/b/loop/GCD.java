package a.b.loop;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int r;
		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		System.out.println(x);
	}

}
