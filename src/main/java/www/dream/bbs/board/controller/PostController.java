package www.dream.bbs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.ReplyVO;
import www.dream.bbs.board.service.PostService;

@RestController  //Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	//테스트용 생성
	public PostController(PostService postService) {
		this.postService = postService;
		
	}

	//http://localhost:8080/post/listAll/000n
	@GetMapping("/listAll/{boardId}") 
	public ResponseEntity<List<PostVO>> listAllPost(@PathVariable String boardId){
		List<PostVO> listAll = postService.listAllPost(boardId);
		return new ResponseEntity<>(listAll, HttpStatus.OK);
		//위와 동일return new ResponseEntity<>(postService.listAllPost(boardId), HttpStatus.OK);
	}
	
	//http://localhost:8080/post/p001
	@GetMapping("/{id}")
	public ResponseEntity<PostVO> findById(@PathVariable String id){
		return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
	}
	
	//http://localhost:8080/post/createPost
	@PostMapping("/createPost")
	public ResponseEntity<Integer> createPost(PostVO post){
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
	}
	
	
//	//http://localhost:8080/post/createPost
//		@PostMapping("/cPost")
//		public ResponseEntity<Integer> cPost(){
//			return new ResponseEntity<>(postService.cPost(), HttpStatus.OK);
//		}
	
	
	//http://localhost:8080/post/createReply
	@PostMapping("/createReply")
	public ResponseEntity<Integer> createReply(ReplyVO parent, ReplyVO reply){
		return new ResponseEntity<>(postService.createReply(parent, reply), HttpStatus.OK);
	}
	
	//http://localhost:8080/post/updatePost
	@PostMapping("/updatePost")
	public ResponseEntity<Integer> updatePost(PostVO post){
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}
	
	//http://localhost:8080/post/updateReply
	@PostMapping("/updateReply")
	public ResponseEntity<Integer> updateReply(ReplyVO reply){
		return new ResponseEntity<>(postService.updateReply(reply), HttpStatus.OK);
	}

	//http://localhost:8080/post/p001
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteReply(@PathVariable String id){
		return new ResponseEntity<>(postService.deleteReply(id), HttpStatus.OK);
	}
	
	
	
}
