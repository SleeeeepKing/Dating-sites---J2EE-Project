package com.example.j2ee_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RelationController {
    @RequestMapping("/Interested")
    public String Interested(){
        return "matches";
    }
    @RequestMapping("/SearchByConditions")
    public String SearchByCondition(){
        return "matches";
    }
}
