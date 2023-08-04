package www.dream.vp.test;

import www.dream.vp.builder.ExpBuilder;
import www.dream.vp.factory.VisitorFactory;
import www.dream.vp.model.Element;
import www.dream.vp.visitor.Visitor;

public class Main2 {

	public static void main(String[] args) {
		// 3 + 5 * 7
		Element top = ExpBuilder.build("3+9*5*6+4+5*7");
		
		Visitor visitor = VisitorFactory.createVisitor("...");// 변수명은 abstract패턴에 맞춰서
		top.accept(visitor);
		System.out.println(visitor.getHistory());
		

	}

}
