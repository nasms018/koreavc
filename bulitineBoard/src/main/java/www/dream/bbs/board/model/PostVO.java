package www.dream.bbs.board.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.bbs.framework.property.anno.TargetProperty;

/**
 * RestController는 client요청에 대한 분배 기능
 */

@Setter
@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostVO extends ReplyVO {
	private BoardVO boardVO;
	@TargetProperty
	private String title;
	private int readCnt;
	private int likeCnt;
	private int disCnt;
	//대댓글 구조 만들기는 어떻게?
//	private List<ReplyVO> listReply;
	
	/**VO ? DTO  // DTO로 활용되는 속성 추가적 정의 부분 */
	private List<String> listTag;
}
