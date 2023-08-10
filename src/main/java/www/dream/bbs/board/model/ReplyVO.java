package www.dream.bbs.board.model;

import java.util.List;

import www.dream.bbs.framework.MasterEntity;
import www.dream.bbs.party.model.PartyVO;

public class ReplyVO extends MasterEntity {
	
	private PartyVO writer; //게시물 작성자
	private String content; //내용
	private String hTier;
	//대댓글 구조 만들기는 어떻게?
	private List<ReplyVO> listReply;
	
}
