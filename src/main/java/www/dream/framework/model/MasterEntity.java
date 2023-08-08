package www.dream.framework.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MasterEntity extends Entity {
	private Date regDt;
	private Date uptDt;

	@Override
	public String toString() {
		return super.toString() + ", reg_dt=" + regDt + ", upt_dt=" + uptDt;
	}

}
