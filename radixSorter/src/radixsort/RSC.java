package radixsort;

import java.util.Arrays;

import www.dream.lib.ArrayHelper;
import www.dream.lib.NumberHelper;
import www.dream.lib.ReferenceHelper;
import www.dream.lib.data.Pair;
import www.dream.lib.discrete.MathHelper;

public class RSC {
	/**
	 * @data 사전식 비교 가능한 원소들의 배열
	 * @radix 기수(10진법을 사용한다면 10)
	 */
	public static <T extends Comparable<T>> T[] rxSort(T[] data, int radix) {
		//숫자의 최대 자리수
		Pair<T, T> minMaxPair = ArrayHelper.findMinMax(data);
		/** 숫자의 최대 자리수 */
		Number fv = NumberHelper.abs((Number) minMaxPair.getFirstVal());
		Number sv = NumberHelper.abs((Number) minMaxPair.getSecondVal());
		Number logest = fv.toString().length() > sv.toString().length() ? fv : sv;

		int maxDigist = MathHelper.maxDigists(logest, radix);
		int datSize = data.length;
		
		int bucketSize = 2 * radix - 1;
		// 특정 자리에서 숫자들의 카운트
		int[] bucketEleCount = new int[bucketSize];

		//해당 자릿수로 정렬한 결과
		T[] sortResult = Arrays.copyOf(data, datSize);

		int i, j, n;
		int curDigit;	//현재 관심 자리
		int[] bucketId = new int[datSize];	//각 데이타 별 방 번호
		// 메모리 할당
		for (n = 0; n < maxDigist; n++) { // 1의 자리, 10의자리, 100의 자리 순으로 진행
			for (i = 0; i < bucketSize; i++)
				bucketEleCount[i] = 0; // 초기화
			// 위치값 계산.
			// n:0 => 1, 1 => 10, 2 => 100
			curDigit = (int) Math.pow(radix, n);

			// 각 숫자의 현재 관심 자리를 기준으로 방별 발생횟수를 센다.
			for (j = 0; j < datSize; j++) {
				// 253이라는 숫자라면
				// n:0 => 3, 1 => 5, 2 => 2
				if (data[j] instanceof Integer)
					bucketId[j] = (int) ((int) data[j] / curDigit) % radix;
				if (data[j] instanceof Long)
					bucketId[j] = (int) ((long) data[j] / curDigit) % radix;
				bucketId[j] += radix - 1;	//음수 다루기 위한 방 번호 밀기
				bucketEleCount[bucketId[j]]++;
			}
			//누적하기.
			for (i = 1; i < bucketSize; i++) {
				bucketEleCount[i] += bucketEleCount[i - 1];
			}
			// 카운트를 사용해 각 항목의 위치를 결정한다.
			// 계수정렬 방식
			for (j = datSize - 1; j >= 0; j--) { // 뒤에서부터 시작
				sortResult[bucketEleCount[bucketId[j]] - 1] = data[j];
				bucketEleCount[bucketId[j]] = bucketEleCount[bucketId[j]] - 1; // 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(sortResult, sortResult = data);
		}
		return data;
	}// 적용안됨
}
