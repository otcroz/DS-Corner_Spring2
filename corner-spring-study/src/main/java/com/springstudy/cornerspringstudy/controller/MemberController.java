package com.springstudy.cornerspringstudy.controller;

import com.springstudy.cornerspringstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 1개를 생성하여 공용으로 사용하면 된다.
    private final MemberService memberService;

    // 스프링 컨테이너에 등록하여 사용한다.

    @Autowired
    // 컨트롤러가 생성될 때 객체를 가져다 쓴다. // 의존관계 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}