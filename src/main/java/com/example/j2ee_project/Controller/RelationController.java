package com.example.j2ee_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RelationController {
    @RequestMapping("/Interested")
    public String Interested(HttpSession session){
        if(session.getAttribute("userName")==null)
            return "redirect:/ToLogin";
        else {
            //list searchbyidF(id)
            //session.setAttribute(list)

        }

        return "redirect:/requestProList";
    }
    @RequestMapping("/SearchByConditions")
    public String SearchByCondition(){
        return "matches";
    }
}
