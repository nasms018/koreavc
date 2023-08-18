package www.dream.bbs.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PartyVO;
import www.dream.bbs.party.model.PersonVO;

@Mapper
public interface PartyMapper {
	// 관리자 입장에서 회사의 발전성 보기위하여 DAU - Daily active/new/out Member count
	// 데일리 신규회원수, 탈퇴회원수... 추세:막대그래프
	// MAU, MAU

	// LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<PersonVO> listAllMember(String ownerId);

	public PartyVO findByNick(String nick);
	
	public int createOrganization(OrganizationVO organization);
	public int createPerson(PersonVO person);
	
	public int createAccountability(AccountabilityVO accountabilityVO);

	
	
	
	/**
	public int updateMember(PersonVO member);
	
	 * 회원탈퇴 처리의 기본전략 isActive : 회원가입시 true 탈퇴시 false (보통 회사에서 많이 쓰는 전략) record
	 * delete : 실제로 삭제
	 
	public int deactivateParty(PartyVO partyVO);*/

}
