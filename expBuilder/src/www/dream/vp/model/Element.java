package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;

public abstract class Element { //class Acceptor
	public abstract void accept(Visitor visitor);
	public abstract String whoAreYou();
}
