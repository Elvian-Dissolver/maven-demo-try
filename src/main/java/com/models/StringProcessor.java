package com.models;

import org.springframework.stereotype.Component;

//@Component
public class StringProcessor {

    public String process(String text){
        return "text : " + text;
    }
}
