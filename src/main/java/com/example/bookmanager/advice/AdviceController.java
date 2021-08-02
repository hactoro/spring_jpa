package com.example.bookmanager.advice;

import com.example.bookmanager.Interceptor.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(IllegalStateException.class)
    protected void exceptionHandler(IllegalStateException e){
      log.info("--------ControllerAdvice--------");
      log.info(e.getMessage());
    }
    @ExceptionHandler(CustomException.class)
    protected void customException(CustomException e){
        log.info("------CustomException--------");
        log.info(e.getMessage());
        log.info(e.getCode());
    }
}
