package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;

/**
 * strategy pattern
 */
public abstract class Visitor {
	private StringBuilder sb = new StringBuilder();

	public void visit(Composer composer) {
	}

	public void visit(Operand operand) {
	}

	public String getHistory() {
		return sb.toString();
	}

	public void recordHistory(String hist) {
		sb.append(hist);
	}

}
