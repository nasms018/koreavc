package www.dream.bbs.bulitine_board.mapper;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.PostVO;

//실 데이터베이스에 연결시 필요한 어노테이션
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostMapperTest {

	@Autowired
	private PostMapper postMapper;

	@Test
	@DisplayName("listAllPost Post Mapper Test")
	public void listAllPost() {
		try {
			// given
			List<PostVO> l = postMapper.listAllPost("000n");

			for (PostVO p : l) {
				System.out.println(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
