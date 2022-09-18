package com.springstudy.cornerspringstudy.controller;

import com.springstudy.cornerspringstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController { // 컨트롤러 객체를 생성하여 스프링에 넣어둔다.
    // 의존 관계: MemberController가 생성되면 스프링 빈에 등록되어 있는 memberService를 넣어준다.


    // new 해서 하면 다른 여러 컨트롤러들이 memberService를 사용할 수 있다.
    // 하나만 생성하여 공용으로 사용하기 위해 스프링 컨테이너에 등록하여 사용한다.
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에서 memberService를 가져온다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
