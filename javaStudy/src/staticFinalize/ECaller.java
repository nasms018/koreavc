package staticFinalize;

public class ECaller {

	public static void main(String[] args) {
		ECaller a = new ECaller();
		a.doX();
		System.gc();
		a.doX();
	}

	private void doX() {
		for (int i = 0; i < 1000000; i++) {
			Emp a = new Emp();
		}
		
		System.out.println(Emp.count);
		
	}

}
