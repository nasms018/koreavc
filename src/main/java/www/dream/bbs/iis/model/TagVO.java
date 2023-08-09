package www.dream.bbs.iis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="T_tag")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TagVO {
	
	@Id
	private String id;
	private String word;
	@Column(name="description")
	private String 단어정의_설명;
	private long df;
	
	
	
	
}
