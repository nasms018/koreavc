package www.dream.bbs.party.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.net.SendfileKeepAliveState;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.framework.model.MasterEntity;
import www.dream.bbs.framework.property.anno.TargetProperty;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class PartyVO extends MasterEntity implements UserDetails{
	
	@TargetProperty
	private String name;
	private String nick;
	//@JsonIgnore  //pwd는 화면에 노출되는 대상이 아님 //보안
	private String pwd;


	// 연락처 목록
	private List<ContactPointVO> listContactPoint = new ArrayList<>();
	private List<AccountabilityVO> listAccountability = new ArrayList<>();
	
	
	public PartyVO(String name, String nick, String pwd, List<ContactPointVO> listContactPoint) {
		this.name = name;
		this.nick = nick;
		this.pwd = pwd;
		this.listContactPoint = listContactPoint;
	}

	public void addCP(ContactPointVO cp) {
		// null pointer
		listContactPoint.add(cp);
	}


	public void encodePwd(PasswordEncoder pwdEnc) {
		pwd = pwdEnc.encode(pwd);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", name=" + name + ", 연락처들=" + listContactPoint;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		List<SimpleGrantedAuthority> ret = new ArrayList<>(); 
		for (AccountabilityVO acc : listAccountability) {
			ret.add(acc.getAuthority());
		}*/ //아래와 동일
			return listAccountability
				.stream()   // 하나씩 빨대로 뽑아 내어
				.map(AccountabilityVO::getAuthority) //getAuthority 함수로 만든결과로 MAP(변환하여)
				.collect(Collectors.toList()); //모을거야
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return nick;
	}

	@Override
	public boolean isAccountNonExpired() {
		return listAccountability.stream().filter(AccountabilityVO::isAlive).count() > 0;
		
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
