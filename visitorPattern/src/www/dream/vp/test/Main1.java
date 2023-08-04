package www.dream.vp.test;

import www.dream.vp.factory.VisitorFactory;
import www.dream.vp.model.Multi;
import www.dream.vp.model.Operand;
import www.dream.vp.model.Plus;
import www.dream.vp.visitor.Visitor;

public class Main1 {

	public static void main(String[] args) {
		//3 + 5 * 7
		Operand sam = new Operand(3);
		Operand oh = new Operand(5);
		Operand ch = new Operand(7);
		Multi multi = new Multi(oh, ch);
		Plus top = new Plus(sam, multi);
		
		Visitor visitor = VisitorFactory.createVisitor("PrefixVisitor");
		//+ 3 * 5 7
		top.accept(visitor);
		System.out.println(visitor.getHistory());
		
		visitor = VisitorFactory.createVisitor("InfixVisitor");
		//3 + 5 * 7
		top.accept(visitor);
		System.out.println(visitor.getHistory());

		visitor = VisitorFactory.createVisitor("...");
		//3  5  7 * +
		top.accept(visitor);
		System.out.println(visitor.getHistory());

	}

}
