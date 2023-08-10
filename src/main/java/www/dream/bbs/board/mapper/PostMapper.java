package www.dream.bbs.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.ReplyVO;

@Mapper   //Container에 담기도록 지정
public interface PostMapper {
	//LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	/**게시판의 모든 원글 목록 조회*/
	public List<PostVO> listAllPost(String boardId);
	/**특정게시물에 따른 원글 상세(첨부파일 목록, 댓글 목록, 대댓글 목록이 채워짐)*/
	public List<ReplyVO> findById(String id);
	
	/* affected row counts 영향받은 행수*/
	/**특정 게시판에 원글등록*/
	public int createPost(PostVO post);
	/**댓글 달기. parant의 hid의 연결된 hid 만들기*/
	public int createReply(@Param("parent") ReplyVO parent, @Param ("reply") ReplyVO reply); //댓글, 대댓글

	/***/
	public int updatePost(PostVO post);
	/***/
	public int updateReply(ReplyVO parent, ReplyVO reply);
	
	/**hid like로 지우기 */
	public int deleteReply(String id);
	
	
}
