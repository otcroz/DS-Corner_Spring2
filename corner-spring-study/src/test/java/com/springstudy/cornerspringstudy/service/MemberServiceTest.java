package com.springstudy.cornerspringstudy.service;

import com.springstudy.cornerspringstudy.domain.Member;
import com.springstudy.cornerspringstudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    // clear을 해준다.
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given : 주어진다.
        Member member = new Member();
        member.setName("hello");

        // when : 실행했을 때, 이 데이터를 기반으로 한다.
        Long saveId = memberService.join(member);

        // then : 이런 결과가 나와야 한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // test는 예외의 경우를 다루는 것이 중요
    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
            memberService.join(member1);
            // 예외를 실행하도록 한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//            try{
//                memberService.join(member2);
//                fail();
//
//            } catch (IllegalStateException e){
//                assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//            }

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}