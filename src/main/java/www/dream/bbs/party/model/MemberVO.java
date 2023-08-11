package www.dream.bbs.party.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberVO extends PartyVO {

	public MemberVO(String id) {
		super(id);
	}
	
	public MemberVO(String name, boolean sex) {
		super(name, sex);
	}

	
	@Override
	public String toString() {
		return "MemberVO [" + super.toString() + "]";
	}
}
