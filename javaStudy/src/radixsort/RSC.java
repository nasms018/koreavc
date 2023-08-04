package radixsort;

import www.dream.lib.ReferenceHelper;

public class RSC {

	public static void main(String[] args) {
		int[] data = { 170, 45, 75, 90, 2, 24, 802, 66 };
		rxSort(data, data.length, 4, 10);
		for (int v : data)
			System.out.print(v + " ");
	}

	/**
	 * @data 정수 배열
	 * @size data의 정수들의 개수
	 * @p 숫자의 최대 자리수
	 * @k 기수(10진법을 사용한다면 10)
	 * 
	 */
	public static void rxSort(int[] data, int size, int p, int k) {
		// 특정 자리에서 숫자들의 카운트
		int[] counts = new int[k];

		int[] temp = new int[size]; // 정렬된 배열을 담을 임시 장소

		int index, pval, i, j, n;
		// 메모리 할당
		for (n = 0; n < p; n++) { // 1의 자리, 10의자리, 100의 자리 순으로 진행
			for (i = 0; i < k; i++)
				counts[i] = 0; // 초기화
			// 위치값 계산.
			// n:0 => 1, 1 => 10, 2 => 100
			pval = (int) Math.pow(k, n);

			// 각 숫자의 발생횟수를 센다.
			for (j = 0; j < size; j++) {
				// 253이라는 숫자라면
				// n:0 => 3, 1 => 5, 2 => 2
				index = (int) (data[j] / pval) % k;
				counts[index] = counts[index] + 1;
			}
			// 카운트 누적합을 구한다. 계수정렬을 위해서.
			for (i = 1; i < k; i++) {
				counts[i] = counts[i] + counts[i - 1];
			}
			// 카운트를 사용해 각 항목의 위치를 결정한다.
			// 계수정렬 방식
			for (j = size - 1; j >= 0; j--) { // 뒤에서부터 시작
				index = (int) (data[j] / pval) % k;
				temp[counts[index] - 1] = data[j];
				counts[index] = counts[index] - 1; // 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(temp, temp = data);
		}
	}// 적용안됨
}
