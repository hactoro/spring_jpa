package com.example.bookmanager.Interceptor;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CustomException extends RuntimeException{
    private String code;
    public CustomException(){
        super("hello");
    }
}

