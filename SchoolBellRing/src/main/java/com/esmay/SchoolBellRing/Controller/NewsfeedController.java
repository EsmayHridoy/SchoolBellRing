package com.esmay.SchoolBellRing.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsfeedController {


    @GetMapping("/profileInfo")
    public String profileButton(){

        return "profile";
    }
}
