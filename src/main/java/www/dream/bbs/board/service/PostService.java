package www.dream.bbs.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.board.mapper.PostMapper;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
//	public List<PostVO> listAll(){
//		return postMapper.listAllPost();
//	}
//	public PostVO findById(String id) {
//		return postMapper.findById(id);
//	}
	
	
}
