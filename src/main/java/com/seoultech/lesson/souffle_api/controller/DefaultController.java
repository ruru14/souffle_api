package com.seoultech.lesson.souffle_api.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@Api(tags = "Default", hidden = true)
public class DefaultController {

    @GetMapping("")
    public String index(){
        return "Hello Souffle!";
    }

}
