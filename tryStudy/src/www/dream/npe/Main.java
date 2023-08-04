package www.dream.npe;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		//참조형 변수의 경우Null Pointer Exception 발생 시키고 효과 보기
		Optional<String> str = getStr();
		String result = str.orElse("못받았음").concat("str");
		System.out.println(result);
		
		//회피 시키기
	}

	private static Optional<String> getStr() {
		Optional<String> ret = Optional.ofNullable("null");
		return ret;
	}

}
