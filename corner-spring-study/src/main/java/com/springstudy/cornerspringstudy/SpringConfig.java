package com.springstudy.cornerspringstudy;

import com.springstudy.cornerspringstudy.repository.MemberRepository;
import com.springstudy.cornerspringstudy.repository.MemoryMemberRepository;
import com.springstudy.cornerspringstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 1. MemberService와 MemberRepository를 스프링 빈에 등록
    // 2. memberRepository를 MemberService에 넣어준다.

    @Bean
    // 이 로직을 호출하여 스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository()); // 스프링빈에 등록된 memberRepository를 넣어준다.
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
