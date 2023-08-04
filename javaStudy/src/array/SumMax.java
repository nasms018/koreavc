package array;

public class SumMax {

	public static void main(String[] args) {
		double[] vals = {};
		double sum = 0, max = Double.MIN_VALUE; 
		//for each 구문
		for (double val : vals) {
			System.out.print(val + " ");
			sum += val;
			if (val > max)
				max = val;
		}
		System.out.println();
		System.out.println("합은 " + sum);
		System.out.println("최대값은 " + max);
	}

}
