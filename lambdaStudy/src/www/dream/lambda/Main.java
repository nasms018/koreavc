package www.dream.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// 1 + 2 + ... + 10 => 55
		List<Integer> intList = IntStream.range(1, 11).boxed().collect(Collectors.toList());

		System.out.println(intList.stream().distinct().findAny());
		System.out.println(IntStream.range(1, 11).average());

		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map : " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch : " + s);
			return s.startsWith("A");
		});
	}

}
