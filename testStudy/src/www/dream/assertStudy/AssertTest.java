package www.dream.assertStudy;

import java.util.Scanner;

public class AssertTest {

	public static void main(String[] args) {
		Scanner inscan = new Scanner(System.in);
		int dt = inscan.nextInt();
		assert(dt >= 1 && dt <= 31);
		
	}

}
