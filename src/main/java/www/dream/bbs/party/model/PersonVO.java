package www.dream.bbs.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonVO extends PartyVO  {
	private boolean sex;
	
	public PersonVO(String name, String nick, String pwd, List<ContactPointVO> listContactPoint, boolean sex) {
		super(name, nick, pwd, listContactPoint);
		this.sex = sex;
		
		
	}
	
	@Override
	public String toString() {
		return super.toString() + ", sex=" + sex;
	}
	
	
	
	
	
}
