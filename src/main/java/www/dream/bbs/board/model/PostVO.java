package www.dream.bbs.board.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostVO extends ReplyVO {
	private BoardVO boardVO;
	private String title;
	private int readCnt;
	private int likeCnt;
	private int disCnt;
	//대댓글 구조 만들기는 어떻게?
//	private List<ReplyVO> listReply;

}
