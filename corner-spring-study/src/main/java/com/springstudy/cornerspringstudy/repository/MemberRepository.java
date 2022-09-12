package com.springstudy.cornerspringstudy.repository;

import com.springstudy.cornerspringstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장
    Optional<Member> findById(Long id); // id 값을 찾는다.
    Optional<Member> findByName(String name); // 이름 값을 찾는다.
    List<Member> findAll(); // 지금까지 찾은 모든 멤버 리스트
}
