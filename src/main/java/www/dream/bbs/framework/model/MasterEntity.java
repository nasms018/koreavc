package www.dream.bbs.framework.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class MasterEntity extends Entity {
	private Date regDt;
	private Date uptDt;

	public MasterEntity(String id) {
		super(id);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", reg_dt=" + regDt + ", upt_dt=" + uptDt;
	}

}
