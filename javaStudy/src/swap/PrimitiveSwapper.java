package swap;

public class PrimitiveSwapper {
	public static <T> T swap(T px, T py) {
		return px;
	}

	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;
		
		y = PrimitiveSwapper.swap(x, x = y);
		
		System.out.println(x);
		System.out.println(y);
	}

}
