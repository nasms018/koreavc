package www.dream.bbs.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import www.dream.bbs.party.model.PartyVO;

@Mapper
public interface PartyMapper {

	public List<PartyVO> listAll();
	//public PartyVO findById(String id);
	
}
