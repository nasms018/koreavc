package www.dream.cme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentModificationEcp {

	public static void main(String[] args) {
		raiseCME();
		raiseCMEIter();
	}

	private static void raiseCME() {
		List<Integer> myList = 목록만들기();
		
		List<Integer> delList = new ArrayList<>(); 
		//홀수는 지워봐
		for (Integer val : myList) {
			if ((val & 0b1) != 0) {
				//myList.remove(val);	CME
				delList.add(val);
			}
		}
		myList.removeAll(delList);
		for (Integer val : myList) {
			System.out.print(val + " ");
		}
	}

	private static void raiseCMEIter() {
		List<Integer> myList = 목록만들기();
		
		Iterator<Integer> iter = myList.iterator();
		while (iter.hasNext()) {
			Integer val = iter.next();
			//짝수는 지워봐
			if ((val & 0b1) == 0) {
				iter.remove();
			}
		}

		for (Integer val : myList) {
			System.out.print(val + " ");
		}
	}

	private static List<Integer> 목록만들기() {
		List<Integer> myList = IntStream.range(10, 15).boxed().collect(Collectors.toList());
		for (Integer val : myList) {
			System.out.print(val + " ");
		}
		System.out.println();
		return myList;
	}

}
