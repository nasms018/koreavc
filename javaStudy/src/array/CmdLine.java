package array;

public class CmdLine {

	public static void main(String[] args) {
		//주어진 인자를 모두 출력하고 첫 인자가 -h면 help를 한번 더 출력
		for (String val : args) {
			System.out.print(val + " ");
		}

		if (args.length > 0) {
			if (args[0].equals("-h"))
				System.out.print(" Help");
		}
	}

}
