package www.dream.bbs.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.BoardVO;
import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.ReplyVO;
import www.dream.bbs.party.model.MemberVO;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	/**게시판의 모든 원글 목록 조회*/
	public List<PostVO> listAllPost(String boardId){
		return postMapper.listAllPost(boardId);
	}
	/**특정게시물에 따른 원글 상세(첨부파일 목록, 댓글 목록, 대댓글 목록이 채워짐)*/
	public PostVO findById(String id){
		//postMapper.findById(id)는 id의 primay key 특성으로 사전순서가 보장되어 있음
		List<ReplyVO> oneDimList = postMapper.findById(id); //id리스트 나옴 //변수명 oneDimList or flatList
		PostVO ret = (PostVO) oneDimList.get(0);
		Map<String, ReplyVO> map = new HashMap<>();
		for (ReplyVO reply : oneDimList) {
			map.put(reply.getId(), reply);
			ReplyVO parent = map.get(reply.extractParentId());		//map.containsKey(map)이런식으로 해도됨
			if(parent != null) {
				parent.appendReply(reply);
			}
		}
		return ret;
	}
	
	/* affected row counts 영향받은 행수*/
	/**특정 게시판에 원글등록*/
	public int createPost(PostVO post) {
		return postMapper.createPost(post);
	}
	/**댓글 달기. parant의 hid의 연결된 hid 만들기*/
	public int createReply(ReplyVO parent, ReplyVO reply) {
		return postMapper.createReply(parent, reply);
	}; //댓글, 대댓글

	/***/
	public int updatePost(PostVO post) {
		return postMapper.updatePost(post);
	}
	/***/
	public int updateReply(ReplyVO reply) {
		return postMapper.updateReply(reply);
	}
	
	/**hid like로 지우기 */
	public int deleteReply(String id) {
		return postMapper.deleteReply(id);
	}
	
//	public int cPost() { //맵퍼테스용 연동잘되는지 보기위해
//		PostVO post = new PostVO();
//		post.setTitle("cPost");
//		post.setContent("확인");
//		post.setBoardVO(new BoardVO("000n"));
//		post.setWriter(new MemberVO("0003"));
//		return postMapper.createPost(post);
//	}
	
	
	
}
