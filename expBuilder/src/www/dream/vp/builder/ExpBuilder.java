package www.dream.vp.builder;

import java.util.Stack;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Element;
import www.dream.vp.model.Mutiply;
import www.dream.vp.model.Operand;
import www.dream.vp.model.Plus;

public class ExpBuilder {

	static char[] ops = new char[] { '+', '*' };

	public static Element build(String exp) {
		Stack<Composer> 연산자쌓기 = new Stack<>();
		Stack<Element> 숫자또는결과쌓기 = new Stack<>();
		int expLength = exp.length();
		int 숫자시작점 = -1;
		for (int i = 0; i < expLength; i++) {
			char iChar = exp.charAt(i);
			Composer operator = null;
			if ((operator = getOperator(iChar)) != null) {
				Operand num = new Operand(Integer.parseInt(exp.substring(숫자시작점, i)));
				숫자또는결과쌓기.push(num);
				숫자시작점 = -1;

				while (!연산자쌓기.isEmpty() && operator.compareTo(연산자쌓기.peek()) < 0) {
					buildOperator(연산자쌓기, 숫자또는결과쌓기);
				}
				연산자쌓기.push(operator);
			} else {
				if (숫자시작점 == -1) {
					숫자시작점 = i;
				}
			}
		}
		Operand num = new Operand(Integer.parseInt(exp.substring(숫자시작점, expLength)));
		숫자또는결과쌓기.push(num);

		while (!연산자쌓기.isEmpty()) {
			buildOperator(연산자쌓기, 숫자또는결과쌓기);
		}

		return 숫자또는결과쌓기.pop();
	}

	private static void buildOperator(Stack<Composer> 연산자쌓기, Stack<Element> 숫자또는결과쌓기) {
		// operatorStack에서 Operator를 pop한 다음
		// elementStack(숫자또는결과쌓기)에서 두 Element를 pop하여 붙여서
		// 붙인 결과물을 elementStack에 push한다
		Composer top = 연산자쌓기.pop();
		top.setRight(숫자또는결과쌓기.pop());
		top.setLeft(숫자또는결과쌓기.pop());
		숫자또는결과쌓기.push(top);
	}

	private static Composer getOperator(char iChar) {
		if (iChar == '+') {
			return new Plus();
		} else if (iChar == '*') {
			return new Mutiply();
		}
		return null;

	}

}
