package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(){
        log.info("hello...?");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1...");
        log.info("name: "+name);
        log.info("age: "+age);
    }
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA")String name,
                    @RequestParam(name = "age", defaultValue = "20")int age){
        log.info("ex2...");
        log.info("name: "+name);
        log.info("age: "+age);
    }

    /**
     * Fomatter를 이용한 파라미터의 커스텀 처리
     * 이유 : HTTP는 기본적으로 문자열 데이터를 주고 받기 때문에 날짜 관련 데이터를 변환 처리하기 힘듦
     * @param dueDate
     */
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3...");
        log.info("dueDate: "+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("---------");
        model.addAttribute("message", "Hello World");
    }
}