package com.springstudy.cornerspringstudy.service;

import com.springstudy.cornerspringstudy.domain.Member;
import com.springstudy.cornerspringstudy.repository.MemberRepository;
import com.springstudy.cornerspringstudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
