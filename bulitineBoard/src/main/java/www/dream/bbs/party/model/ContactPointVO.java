package www.dream.bbs.party.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ContactPointVO { //매니저,멤버 같은 타입
	//오너id를 안넣는 이유 - 코드 정의해뒀고 이미 담겨있음
	//private Party owner; //양방향 접근성은 함부로 만들지 않음
	private String cpType;
	private String cpVal;
	@Override
	public String toString() {
		return "[cpType=" + cpType + ", cpVal=" + cpVal + "]";
	}
	
}
