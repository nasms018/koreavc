package www.dream.bbs.board.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import www.dream.bbs.framework.nlp.pos.service.NounExtractor;
/**
 *@RestControllersms client 요청에 대한 분배 기능
 *service로 처리 위함하여 그 결과를 client에게 반환
 *길게 업무적 처리가 들어와 있으면 실수한 것임
 */
@RestController // Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	// 테스트용 생성
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// http://localhost:8080/post/listAll/000n
	@GetMapping("/listAll/{boardId}")
	public ResponseEntity<List<PostVO>> listAllPost(@PathVariable String boardId) {
		List<PostVO> listAll = postService.listAllPost(boardId);
		return new ResponseEntity<>(listAll, HttpStatus.OK);
		// 위와 동일return new ResponseEntity<>(postService.listAllPost(boardId),
		// HttpStatus.OK);
	}

	// http://localhost:8080/post/getPost/p001
	@GetMapping("/getPost/{id}")
	public ResponseEntity<PostVO> findById(@PathVariable String id) {
		PostVO post = postService.findById(id);
		if (post ==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
	}

	// post/extractTag?docs=안녕하세요&docs=데이터분석
	// 유일 단어 집합
	@GetMapping("/extractTag")
	public ResponseEntity<Set<String>> extractTag(String[] docs) {
		Set<String> ret = new HashSet<>();
		for (String doc : docs) {
			ret.addAll(NounExtractor.extractNoun(doc));
		}
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}

	// post/extractTag?docs=안녕하세요&docs=데이터분석
	// 유일 단어 집합
//	@GetMapping("/extractTagOld")
//	public ResponseEntity<List<Pair<String, Integer>>> extractTagOld(String[] docs) {
//		List<Pair<String, Integer>> ret = new ArrayList<>();
//
//		List<String> listNoun = new ArrayList<>();
//		for (String doc : docs) {
//			listNoun.addAll(NounExtractor.extractNoun(doc));
//		}
//		Map<String, Integer> mapWordCnt = new HashMap<>();
//		for (String noun : listNoun) {
//			if (mapWordCnt.containsKey(noun)) {
//				mapWordCnt.put(noun, mapWordCnt.get(noun) + 1);
//			} else {
//				mapWordCnt.put(noun, 1);
//			}
//		}
//		mapWordCnt.forEach((key, val) -> {
//			ret.add(new Pair(key, val));
//		});
//		// 바로 위와 동일
//		// for (Entry<String, Integer> e : mapWordCnt.entrySet()) {
//		// ret.add(new Pair(e.getKey(), e.getVal()));
//		// }
//		return new ResponseEntity<>(ret, HttpStatus.OK);
//	}

	// http://localhost:8080/post/createPost
	@PostMapping("/createPost")
	public ResponseEntity<Integer> createPost(PostVO post) {
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
	}

//	//http://localhost:8080/post/createPost
//		@GetMapping("/cPost")
//		public ResponseEntity<Integer> cPost(){
//			return new ResponseEntity<>(postService.cPost(), HttpStatus.OK);
//		}

	// http://localhost:8080/post/createReply
	@PostMapping("/createReply")
	public ResponseEntity<Integer> createReply(ReplyVO parent, ReplyVO reply) {
		return new ResponseEntity<>(postService.createReply(parent, reply), HttpStatus.OK);
	}

	// http://localhost:8080/post/updatePost
	@PostMapping("/updatePost")
	public ResponseEntity<Integer> updatePost(PostVO post) {
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}

	// http://localhost:8080/post/updateReply
	@PostMapping("/updateReply")
	public ResponseEntity<Integer> updateReply(ReplyVO reply) {
		return new ResponseEntity<>(postService.updateReply(reply), HttpStatus.OK);
	}

	// http://localhost:8080/post/p001
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteReply(@PathVariable String id) {
		return new ResponseEntity<>(postService.deleteReply(id), HttpStatus.OK);
	}

}
