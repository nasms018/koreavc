package www.dream.bbs.security.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import www.dream.bbs.common.CommonResponse;
import www.dream.bbs.common.exception.BusinessException;
import www.dream.bbs.common.exception.ErrorCode;
import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.PartyVO;
import www.dream.bbs.party.model.PersonVO;
import www.dream.bbs.security.config.JwtTokenProvider;
import www.dream.bbs.security.dto.SignInResultDto;
import www.dream.bbs.security.dto.SignUpResultDto;

// 예제 13.25
@Service
public class SignService{

	private final Logger LOGGER = LoggerFactory.getLogger(SignService.class);

	public PartyMapper partyMapper;
	public JwtTokenProvider jwtTokenProvider;
	public PasswordEncoder passwordEncoder;

	@Autowired
	public SignService(PartyMapper partyMapper, JwtTokenProvider jwtTokenProvider,
			PasswordEncoder passwordEncoder) {
		this.partyMapper = partyMapper;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = passwordEncoder;
	}


	/** 회원가입*/
	public SignUpResultDto signUp(String companyId, String id, String password, String name) {
		LOGGER.info("[getSignUpResult] 회원 가입 정보 전달");
		PersonVO user;
		user = PersonVO.builder().nick(id).pwd(passwordEncoder.encode(password)).name(name).build();
		//테이블 용 id는 채워신 상태로 변화함. see Mapper.xml
		partyMapper.createPerson(user); 
		AccountabilityVO memberRole = new AccountabilityVO("member", companyId, user.getId());
		List<AccountabilityVO> roles =  Collections.singletonList(memberRole);
		partyMapper.createAccountability(memberRole);

		SignUpResultDto signUpResultDto = new SignInResultDto();

		LOGGER.info("[getSignUpResult] 정상 처리 완료");
		setSuccessResult(signUpResultDto);
		return signUpResultDto;
	}

	/** 로그인 처리*/
	public SignInResultDto signIn(String nick, String rawPassword) throws BusinessException {
		LOGGER.info("[getSignInResult] signDataHandler 로 회원 정보 요청");
		PartyVO user =partyMapper.findByNick(nick);
		LOGGER.info("[getSignInResult] Id : {}", nick);

		LOGGER.info("[getSignInResult] 패스워드 비교 수행");
		if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
			throw new BusinessException("잘못된 암호", ErrorCode.WRONG_PWD);
		}
		LOGGER.info("[getSignInResult] 패스워드 일치");

		LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
		SignInResultDto signInResultDto = SignInResultDto.builder()
				.token(jwtTokenProvider.createToken(String.valueOf(user.getNick()), 
						user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))).build();

		LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
		setSuccessResult(signInResultDto);

		return signInResultDto;
	}

	// 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
	private void setSuccessResult(SignUpResultDto result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}

	// 결과 모델에 api 요청 실패 데이터를 세팅해주는 메소드
	private void setFailResult(SignUpResultDto result) {
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(CommonResponse.FAIL.getMsg());
	}
}