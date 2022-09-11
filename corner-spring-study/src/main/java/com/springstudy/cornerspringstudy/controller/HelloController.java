package com.springstudy.cornerspringstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // get
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // key, value
        return "hello"; // resource > hello.html => hello.html를 찾고 렌더링 실행
    }
}
