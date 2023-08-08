package www.dream.bulitine_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bulitine_board.model.BoardVO;
import www.dream.bulitine_board.model.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> listAll(){
		return boardMapper.listAll();
	}
	public BoardVO findById(String id) {
		return boardMapper.findById(id);
	}
	
	
}
