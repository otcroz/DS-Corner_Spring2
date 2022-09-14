package com.springstudy.cornerspringstudy.service;

import com.springstudy.cornerspringstudy.domain.Member;
import com.springstudy.cornerspringstudy.repository.MemberRepository;
import com.springstudy.cornerspringstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 스프링이 서비스임을 인식하고 컨테이너에서 서비스 등록
@Service
public class MemberService { // cmd + shift + t => test

    private final MemberRepository memberRepository;

    @Autowired
    // MemberService 객체가 생성될 때, 컨테이너가 서비스를 등록하면서 
    // 아래 생성자를 호출, MemberRepository를 생성
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
