package www.dream.bb.service;

import jakarta.servlet.http.HttpServletRequest;

public class SCalc {
	public static int calc(HttpServletRequest req) {
		int operandFirst = Integer.parseInt(req.getParameter("operandFirst"));
		String operator = req.getParameter("operator");
		int operandSecond = Integer.parseInt(req.getParameter("operandSecond"));
//		return calc(operandFirst, operator, operandSecond);
//	}
//	private static int calc(int operandFirst, String operator, int operandSecond) {
		int result = 0;

		switch (operator) {
		case "+":
			result = operandFirst + operandSecond;
			break;
		case "-":
			result = operandFirst - operandSecond;
			break;
		case "*":
			result = operandFirst * operandSecond;
			break;
		case "/":
			result = operandSecond == 0 ? Integer.MAX_VALUE : operandFirst / operandSecond;
			break;
		}

		return result;

	}
}
