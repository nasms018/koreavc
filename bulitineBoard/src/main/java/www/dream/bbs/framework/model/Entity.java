package www.dream.bbs.framework.model;

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
public abstract class Entity {
	/**  DDL : idfunc.sql에서의 id 길이에 마주는 것*/
	public static final int ID_LENGTH = 4;
	
	//primitive type의 경우 기본값. reference type의 경우 .. null
	private String id;
	
	@Override
	public String toString() {
		return "id=" + id;
	}

}
