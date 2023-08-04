package www.dream.vp.model;

public class Plus extends Composer {
	public static final char displayChar = '+';

	public Plus(Element left, Element right) {
		super(left, right);
	}
	
	public String whoAreYou() {
		return Character.toString(displayChar);
	}

}
