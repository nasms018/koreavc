package www.dream.bbs.iis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.iis.model.TagVO;
import www.dream.bbs.iis.service.TagService;

@RestController // Container에 담기도록 지정
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@GetMapping("/{word}/{desc}")
	public ResponseEntity<TagVO> createTag(@PathVariable String word, @PathVariable String desc) {
		TagVO tagWithID = tagService.createTag(new TagVO(word, desc));
		return new ResponseEntity<>(tagWithID, HttpStatus.OK);
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<TagVO>> listAll() {
		List<TagVO> listTag = tagService.getAll();
		return new ResponseEntity<>(listTag, HttpStatus.OK);
	}

	@GetMapping("/{id}") // 부르는 주소
	public ResponseEntity<Optional<TagVO>> getTag(@PathVariable String id) { // jsp로 넘길정보
		// TagVO tag = tagService.getTag(id).get();
		Optional<TagVO> optionalTag = tagService.getTag(id);
		if (optionalTag.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(optionalTag, HttpStatus.OK); // 파일명

		}
	}
}
