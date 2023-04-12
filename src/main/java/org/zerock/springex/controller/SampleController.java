package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

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

    /**
     * @ModelAttribute 설정
     * 파라미터를 객체를 받을 경우 자동으로 JSP에서 객체를 사용할 수 있지만 변수명을 지정할 수 없으므로
     * ModelAttribute("변수명")을 사용하여 변수명을 지정한다.
     */
    @GetMapping("/ex4_1")
    public void ex4_1(@ModelAttribute("dto") TodoDTO todoDTO, Model model){
        log.info(todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){
        /**
         * redirectAttributes.addAttribute() : 리다이렉트할 URL(ex6)에 쿼리스트링으로 추가
         * localhost:8080/ex6?name=ABC으로 붙음
         */
        redirectAttributes.addAttribute("name", "ABC");
        //redirectAttributes.addFlashAttribute() : 리다이렉트한 페이지에서 일회성으로 사용 가능한 데이터가 됨
        redirectAttributes.addFlashAttribute("result","success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }
    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1..."+p1);
        log.info("p2..."+p2);
    }
}
