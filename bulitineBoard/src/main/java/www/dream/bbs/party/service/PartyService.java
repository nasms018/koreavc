package www.dream.bbs.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PersonVO;

@Service
public class PartyService implements UserDetailsService{ //stateless service
	
	@Autowired
	private PartyMapper partyMapper;
	@Autowired
	private PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
	
	public List<PersonVO> listAllMember(String ownerId){
		return partyMapper.listAllMember(ownerId);
	}
	
	public int createOrganization(OrganizationVO organization){
		organization.encodePwd(pwdEnc);
		return createOrganization(organization);
	}
	
	public int createManager(OrganizationVO organization, PersonVO person){
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);
		partyMapper.createAccountability(new AccountabilityVO("manager",organization.getId(), person.getId()));
		return cnt;
	}
	
	/** 회원가입*/
	public int createMember(OrganizationVO organization, PersonVO person){
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);
		partyMapper.createAccountability(new AccountabilityVO("member",organization.getId(), person.getId()));
		return cnt;
	}
	
	
	public int createAccountability(AccountabilityVO accountabilityVO){
		return createAccountability(accountabilityVO);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return partyMapper.findByNick(username);
	}

	
	
}
