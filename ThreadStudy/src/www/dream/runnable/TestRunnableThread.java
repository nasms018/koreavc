package www.dream.runnable;

public class TestRunnableThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable("A"));
		Thread t2 = new Thread(new MyRunnable("B"));
		t1.start();
		t2.start();
	}

}

class MyRunnable implements Runnable {
	private String name;
	
	protected MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		//Thread execution start Point
		for (int i = 0; i < 10; i++) {
			System.out.print(name + i + " ");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
