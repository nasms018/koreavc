package www.dream.list;

import java.util.ArrayList;
import java.util.List;

public class ListApis {

	public static void main(String[] args) {
		List<String> sentence = new ArrayList<>();
		sentence.add("null 111");
		sentence.add("null 222");
		sentence.add("null 333");
		
		sentence.add(1, "null 444");
		System.out.println(sentence);
	}

}
