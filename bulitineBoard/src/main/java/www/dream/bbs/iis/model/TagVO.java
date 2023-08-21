package www.dream.bbs.iis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * iis inverted index search
 */

@Entity
@Table(name="T_tag")
@Getter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TagVO {
	
	@Id
	private String id;
	private String word;
	@Column(name="description")
	private String 단어정의_설명;
	private long df;
	
	public TagVO() {
		
	}
	
	public TagVO(String word, String 단어정의_설명) {
		this.word = word;
		this.단어정의_설명 = 단어정의_설명;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
