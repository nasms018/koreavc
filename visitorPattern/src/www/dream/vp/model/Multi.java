package www.dream.vp.model;

public class Multi extends Composer {
	public static final char displayChar = '*';

	public Multi(Element left, Element right) {
		super(left, right);
	}
	
	public String whoAreYou() {
		return Character.toString(displayChar);
	}

}
