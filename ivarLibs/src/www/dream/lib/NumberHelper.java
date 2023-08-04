package www.dream.lib;

public class NumberHelper {
	public static Number abs(Number a) {
		Number x = null;
		if (a instanceof Integer)
			x = (Number) Math.abs((int) a);
		if (a instanceof Long)
			x = (Number) Math.abs((long) a);
		return x;
	}
}