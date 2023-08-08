package www.dream.bulitine_board.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.framework.model.Entity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BoardVO extends Entity {
	private String name; // 이름
	private String descrip; // 설명
	private long postCnt = 0; // 총 게시물 갯수
	
	/**
	 * 사용자(매니저)로부터 정보가 만들어 질때 사용
	 * 
	 * @param name
	 * @param descrip
	 */
	public BoardVO(String name, String descrip) {
		this.name = name;
		this.descrip = descrip;
	}

	@Override
	public String toString() {
		return "BoardVO [" + super.toString() + ", name=" + name + ", descrip=" + descrip + ", postCnt=" + postCnt
				+ "]";
	}

}
