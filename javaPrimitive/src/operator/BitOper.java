package operator;

public class BitOper {

	public static void main(String[] args) {
		System.out.println((long) 0b1111);
		
		int x = 0b0;	//0
		System.out.println(x);
		x = 0b11111111111111111111111111111111;	//-1
		System.out.println(x);
		x = 0b11111111111111111111111111111110;	//-2
		System.out.println(x);
		x = 0b10000000000000000000000000000000;	//-21.....억
		System.out.println(x);
		shift();
		
		findSingle();
	}

	private static void shift() {
		int x = 0b01000000000011111111110101010101;
		System.out.println(x);
		System.out.println(x<<3);
		int y = 0b00000000011111111110101010101000;
		System.out.println(y);
	}

	private static void findSingle() {
		
	}
}
