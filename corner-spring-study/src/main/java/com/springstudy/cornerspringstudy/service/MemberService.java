package com.springstudy.cornerspringstudy.service;

import com.springstudy.cornerspringstudy.domain.Member;
import com.springstudy.cornerspringstudy.repository.MemberRepository;
import com.springstudy.cornerspringstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// @Component: @Service에 @Component가 등록되어 있다.
// @Repository와 Controller도 마찬가지
// 스프링이 서비스임을 인식하고 컨테이너에서 서비스 등록
public class MemberService { // cmd + shift + t => test

    private final MemberRepository memberRepository;

    // MemberService를 생성할 때, 스프링 컨테이너에 등록하면서 MemberRepository를 넣어준다.
    // 구현체인 MemoryMemberRepository를 넣어준다.

    // 생성자 주입 방식
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /* 회원 가입 */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member);
        // 저장
        memberRepository.save(member);
        return member.getId();
    }

    /* 중복 여부 확인 */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // name을 찾는다.
                .ifPresent( m -> { // 존재하는 회원 이름이 있는 경우
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /* 회원 아이디 조회 */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
