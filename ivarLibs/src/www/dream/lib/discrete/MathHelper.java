package www.dream.lib.discrete;

public class MathHelper {
	/**
	 * 진법에 따른 최대 자릿수
	 */
	private static int maxDigists(int val, int radix) {
		return (int) Math.ceil(Math.log(val) / Math.log(radix));
	}

	private static int maxDigists(long val, int radix) {
		return (int) Math.ceil(Math.log(val) / Math.log(radix));
	}
	
	/**
	 * 
	 * @param <T> int, long만 지금 지원합니다.
	 * @param val
	 * @param radix
	 * @return
	 */
	public static <T> int maxDigists(T val, int radix) {
		if (val instanceof Integer)
			return maxDigists((int) val, radix);
		if (val instanceof Long)
			return maxDigists((long) val, radix);
		return 0;
	}
	
}
