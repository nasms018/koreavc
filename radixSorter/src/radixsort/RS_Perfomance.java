package radixsort;

import java.util.Arrays;

import www.dream.lib.ReferenceHelper;

public class RS_Perfomance {
	private static final byte MASK = 0b1111, MASK_LENGTH = 4;

	public static long[] rxSort(long[] data) {
		int datSize = data.length;
		long[] sortResult = Arrays.copyOf(data, datSize);
		
		// 버킷별 요소 개수
		int[] dataSizePerBucket = new int[MASK + 1];
		//각 데이타 별 버킷 번호
		byte[] bucketId = new byte[datSize];	

		//마지막 처리 용도로 정의
		int positiveCount = 0;
		
		for (int shiftCnt = 0; shiftCnt < Long.SIZE; shiftCnt += MASK_LENGTH) {
			for (int i = 0; i <= MASK; i++) {
				dataSizePerBucket[i] = 0;	//개수 초기화
			}

			// 각 숫자의 현재 관심 자리를 기준으로 방별 발생횟수를 센다.
			for (int j = 0; j < datSize; j++) {
				bucketId[j] = (byte) ((data[j] >> shiftCnt) & MASK);
				dataSizePerBucket[bucketId[j]]++;
			}

			//누적하기.
			for (int i = 1; i < MASK + 1; i++) {
				dataSizePerBucket[i] += dataSizePerBucket[i - 1];
				if (i == MASK / 2) {
					positiveCount = dataSizePerBucket[i];
				}
			}

			// 카운트를 사용해 각 항목의 위치를 결정한다.
			// 계수정렬 방식
			for (int j = datSize - 1; j >= 0; j--) { // 뒤에서부터 시작
				sortResult[dataSizePerBucket[bucketId[j]] - 1] = data[j];
				dataSizePerBucket[bucketId[j]]--;// 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(sortResult, sortResult = data);
		}
		//양수 넣기
		System.arraycopy(data, 0, sortResult, datSize - positiveCount, positiveCount);
		//음수 넣기
		System.arraycopy(data, positiveCount, sortResult, 0, datSize - positiveCount);
		return sortResult;
	}
	
	public static void main(String[] args) {
		long[] data = {0, 1, -1, -128, 127, -127, 126, 
				0b00000000, 0b00001000, 0b00010000, 0b00011000,
				(byte)0b10000000, (byte)0b10001000, (byte)0b10010000, (byte)0b10011000};
		for (long d : data)
			System.out.print(d + " ");
		System.out.println();
		data = rxSort(data);
		for (long d : data)
			System.out.print(d + " ");
	}
}
