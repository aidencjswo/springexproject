package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list(){
        log.info("todo list...");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register...");
    }

    /**
     * 스프링 4.0 이후부터 사용 가능한 어노테이션
     * @GetMapping
     * @PostMapping
     */
    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO){
        log.info("POST todo register...");
        log.info(todoDTO);
    }


}
