package com.sevgmo.stationpassport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


    @Controller
    public class MyController {

        @GetMapping("/")
        public ModelAndView index() {
            ModelAndView mav = new ModelAndView("index");
            return mav;
        }
    }

