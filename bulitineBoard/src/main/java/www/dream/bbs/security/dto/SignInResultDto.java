package www.dream.bbs.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 결과 정보
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignInResultDto extends SignUpResultDto {

    private String token;	//JWT

    @Builder
    public SignInResultDto(boolean success, int code, String msg, String token) {
        super(success, code, msg);
        this.token = token;
    }

}