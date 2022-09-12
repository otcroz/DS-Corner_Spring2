package com.springstudy.cornerspringstudy.repository;

import com.springstudy.cornerspringstudy.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id 세팅
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이 나올 경우를 고려
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 인자로 들어온 이름과 동일한 이름 찾기
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // member 반환
    }

    public void clearStore(){
        store.clear();
    }
}
