package org.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    @ResponseBody//문자열이나 JSON 데이터를 그대로 전송 할 때 사용 되는 어노테이션
    @ExceptionHandler(NumberFormatException.class)//예외를 지정해줄 수 있음
    public String exceptNumber(NumberFormatException numberFormatException){
        log.error("----------------------------------");
        log.error(numberFormatException.getMessage());

        return "NUMBER FORMAT EXCEPTION";
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception){
        log.error("----------------------------------");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>"+exception.getMessage()+"</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }
}
