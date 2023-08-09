package www.dream.bbs.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity {
	//primitive type의 경우 기본값. reference type의 경우 .. null
	private String id;

	@Override
	public String toString() {
		return "id=" + id;
	}

}
