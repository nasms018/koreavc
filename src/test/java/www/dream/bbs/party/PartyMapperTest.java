package www.dream.bbs.party;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.ContactPointVO;
import www.dream.bbs.party.model.OrganizationVO;

//실 데이터베이스에 연결시 필요한 어노테이션
@ExtendWith(SpringExtension.class)
@MybatisTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PartyMapperTest {

	@Autowired
	private PartyMapper partyMapper;

	@Test
	@DisplayName("CreateOrganization Test")
	@Rollback(false)
	public void testCreateOrganization() {
		try {
			
			PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
			String pwd = pwdEnc.encode("dream");
			
			//String pwd = "dream";
			List<ContactPointVO> listContactPoint = new ArrayList<>();
			
			listContactPoint.add(new ContactPointVO("hand phone number","010-0098-0999"));
			listContactPoint.add(new ContactPointVO("home phone number","서울 은평 녹번 000길"));
			
			
			OrganizationVO dream = new OrganizationVO("Dream Company","dream", pwd, listContactPoint);
			partyMapper.createMOrganization(dream);
			
			System.out.println(dream.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
