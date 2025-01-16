package me.ahngeunsu.springbootdeveloper.config.jwt;

import io.jsonwebtoken.Jwts;
import me.ahngeunsu.springbootdeveloper.domain.User;
import me.ahngeunsu.springbootdeveloper.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProperties jwtProperties;

    // 1. generateToken() 검증 테스트
    @DisplayName("/generateToken() : 유저 정보와 만료 기간을 전달해 토큰 생성 가능")
    @Test
    void generateToken() {
        // given
        User testUser = userRepository.save(User.builder()
                .email("user@gmail.com")
                .password("test")
                .build());

        // when
        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));

        // then
        Long userId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id",Long.class);

        assertThat(userId).isEqualTo(testUser.getId());
    }
}
/*
    1. generateToken
        given : 토큰에 유저 정보를 추가하기 위한 테스트 유저 생성
        when : 토큰 제공자의 generateToken() 메서드를 호출 -> 토큰 생성
        then : jjwt 라이브러리를 사용하여 토큰을 복호화
            -> 토큰을 만들 때 클레임으로 넣어둔 id 값이 given 절에서 만든
                유저 ID와 동일한지 확인
 */