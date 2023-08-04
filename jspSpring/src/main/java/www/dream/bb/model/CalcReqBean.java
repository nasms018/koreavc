package www.dream.bb.model;

import jakarta.servlet.http.HttpServletRequest;

public class CalcReqBean {
	private int operandFirst;
	private String operator;
	private int operandSecond;

	public int calc() {
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

	public int getOperandFirst() {
		return operandFirst;
	}

	public String getOperator() {
		return operator;
	}

	public int getOperandSecond() {
		return operandSecond;
	}

	public void setOperandFirst(int operandFirst) {
		this.operandFirst = operandFirst;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setOperandSecond(int operandSecond) {
		this.operandSecond = operandSecond;
	}

	@Override
	public String toString() {
		return "CalcReqBean [operandFirst=" + operandFirst + ", operator=" + operator + ", operandSecond="
				+ operandSecond + "]";
	}

	public int[] getArr() {
		return new int[] { 2, 5, 7 };
	}
	
}
