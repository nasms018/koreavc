package www.dream.bbs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.board.service.PostService;

@RestController  //Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
//	@GetMapping("/listAll")
//	public ResponseEntity<List<PostVO>> listAll(){
//		List<PostVO> list = postService.listAll();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}") // 부르는 주소
//	public ResponseEntity<PostVO> findById(@PathVariable String id) { // jsp로 넘길정보
//		PostVO board = postService.findById(id);
//		return new ResponseEntity<>(board, HttpStatus.OK); // 파일명
//	}
	
	
}
