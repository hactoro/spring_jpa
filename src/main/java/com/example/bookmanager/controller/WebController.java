package com.example.bookmanager.controller;

import com.example.bookmanager.Interceptor.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //web page return
@RequestMapping("/")
public class WebController {

    @RequestMapping("/main")
    public void main() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/main");

        CustomException customException = new CustomException();
        customException.setCode("test custom");
        throw customException;
//        return mv;
    }
}
