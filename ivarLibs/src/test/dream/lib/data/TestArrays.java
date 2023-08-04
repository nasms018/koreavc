package test.dream.lib.data;

import www.dream.lib.ArrayHelper;
import www.dream.lib.data.Pair;

public class TestArrays {

	public static void main(String[] args) {
		Integer[] data = { 5, 3, 8 };
		Pair<Integer, Integer> mm = ArrayHelper.findMinMax(data);
		System.out.println("최대값 : " + mm.getSecondVal());
		System.out.println("최소값 : " + mm.getFirstVal());
	}

}
