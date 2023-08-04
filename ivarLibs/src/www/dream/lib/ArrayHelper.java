package www.dream.lib;

import www.dream.lib.data.Pair;

public class ArrayHelper {
	/**
	 * @return first : 최소값, second : 최대값
	 */
	public static <T extends Comparable<T>> Pair<T, T> findMinMax(T[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		
		T max = data[0]; // 최대값
		T min = data[0]; // 최소값

		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(max) > 0) {
				// max의 값보다 array[i]이 크면 max = array[i]
				max = data[i];
			}

			if (data[i].compareTo(min) < 0) {
				// min의 값보다 array[i]이 작으면 min = array[i]
				min = data[i];
			}
		}

		return new Pair<>(min, max);
	}
}
