package www.dream.bbs.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.PartyVO;

@Service
public class PartyService {
	
	@Autowired
	private PartyMapper partyMapper;
	
	public List<PartyVO> listAllMember(){
		return null; //partyMapper.listAllMember();
	}
//	public PartyVO findById(String id) {
//		return partyMapper.findById(id);
//	}
	
	
}
