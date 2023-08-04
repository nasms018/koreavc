package www.dream.layeredApproach;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		System.out.println(readString());
	}

	private static String readString() {
		byte[] buf = new byte[10];
		System.out.println("type str");
		try {
			System.in.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(buf);
	}
}
