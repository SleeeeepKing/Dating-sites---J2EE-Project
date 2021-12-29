package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.RelationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class RelationController {
    @RequestMapping("/Interested")
    public String Interested(HttpSession session){
        if(session.getAttribute("userName")==null)
            return "redirect:/ToLogin";
        else {
            //list searchbyidF(id)
            //session.setAttribute(Interestedlist，List)
            //session.setAttribute(by

        }

        return "redirect:/requestProList";
    }
    @RequestMapping("/addRelation/{idT}")
    public String addRelation(@PathVariable("idT") Integer idT, HttpSession session){
        if(session.getAttribute("userName")!=null)
            return "create_profile";
        else
            session.setAttribute("userId",1);
        Integer idF=(Integer) session.getAttribute("userId");
        RelationEntity r=new RelationEntity();
        r.setIdFollowFrom(idF);
        r.setIdFollowTo(idT);
        System.out.println(r);


        return "redirect:/ToProfile/"+idT;
    }
    @RequestMapping("/ajaxtest")
    @ResponseBody
    public String ajaxtest(){

        return "wyTest";

    }
}
