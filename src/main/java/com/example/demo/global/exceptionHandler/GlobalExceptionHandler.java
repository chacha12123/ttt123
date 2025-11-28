package com.example.demo.global.exceptionHandler;

import com.example.demo.domain.post.post.RsData;
import com.example.demo.global.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public RsData handleException() {

        RsData rsData = new RsData();
        rsData.setResultCode("401");
        rsData.setMessage("없는 회원입니다.");
        return rsData;

    }
}
