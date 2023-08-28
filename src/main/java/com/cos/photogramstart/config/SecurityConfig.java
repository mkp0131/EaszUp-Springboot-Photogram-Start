package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당파일로 시큐리티 설정
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf token 비활성화
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/subscribe/**", "/comment/**")
                .authenticated() // antMatchers 에 입력한 url 은 로그인이 필요
                .anyRequest().permitAll() // 다른 요청들은 모두 허용
                .and().formLogin().loginPage("/auth/signin") // 로그인 loginPage 에 설정한 url로 리다이렉트
                .defaultSuccessUrl("/"); // 로그인 성공시 "/" url 로 이동

    }
}
