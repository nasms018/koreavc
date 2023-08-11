package www.dream.bbs.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.ReplyVO;

@Mapper   //Container에 담기도록 지정
public interface PostMapper {
	//LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<PostVO> listAllPost(String boardId);
	public List<ReplyVO> findById(String id);
	
	/* affected row counts 영향받은 행수*/
	public int createPost(PostVO post);
	public int createReply(@Param("parent") ReplyVO parent, @Param ("reply") ReplyVO reply); //댓글, 대댓글

	public int updatePost(PostVO post);
	public int updateReply(ReplyVO reply);
	
	public int deleteReply(String id);
	
}
