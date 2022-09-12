package com.springstudy.cornerspringstudy.repository;

import com.springstudy.cornerspringstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // ** 중요: test가 끝나면 data를 clear 해줘야 한다.
    @AfterEach
    public void afterEach(){ // test가 실행되고 끝날 때마다 저장소를 비워준다.
        repository.clearStore();
    }

    @Test // test를 임포트하면 동작을 확인할 수 있다.
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member); // member을 저장한다.

        Member result = repository.findById(member.getId()).get(); // 값을 꺼내준다.
        assertThat(member).isEqualTo(result);

        // Assertions.assertEquals(member, null);
        // System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member1);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
