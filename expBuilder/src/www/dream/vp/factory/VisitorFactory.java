package www.dream.vp.factory;

import www.dream.vp.visitor.InfixVisitor;
import www.dream.vp.visitor.PostfixVisitor;
import www.dream.vp.visitor.PrefixVisitor;
import www.dream.vp.visitor.Visitor;

public class VisitorFactory {
	public static Visitor createVisitor(String type) {
		//if(type.equals("InfixVisitor")이면 널포인트익셉션이 발생
		if("InfixVisitor".equals(type))   
			return new InfixVisitor();
		if("PrefixVisitor".equals(type)) 
			return new PrefixVisitor();
		return new PostfixVisitor();
			
	}
}
