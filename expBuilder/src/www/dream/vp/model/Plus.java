package www.dream.vp.model;

public class Plus extends Composer {
	public static final int priority = 2;
	private static final char displayChar = '+';

	public Plus(Element left, Element right) {
		super(left, right);
	}

	public Plus() {

	}

	public String whoAreYou() {

		return Character.toString(displayChar);
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Composer o) {
		return o == null ? 1 : o.getPriority() - priority;
	}

}
