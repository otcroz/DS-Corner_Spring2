package com.springstudy.cornerspringstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // get
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // key, value
        return "hello"; // resource > hello.html => hello.html를 찾고 렌더링 실행
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 통신 프로토콜에서 body 부의 data를 아래의 내용을 직접 넣는다.
    public String helloString(@RequestParam("name") String name){
         return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 반환, 디폴트로 데이터를 json 방식으로 만들어서 반환하는 것이 기본 정책
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
