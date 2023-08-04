package staticFinalize;

public class Emp {
	
	static int count = 0;
	int age = 10;
	
	{
		++count;
	}
	
	@Override
	protected void finalize() throws Throwable {
		--count;
		super.finalize();
	}
}
