package com.example.j2ee_project.Controller;


import com.example.j2ee_project.Service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class RelationController {
    @Autowired private RelationService relationService;
    @RequestMapping("/Interested")
    public String Interested(HttpSession session){
        if(session.getAttribute("userName")==null)
            return "redirect:/ToLogin";
        else {
            session.setAttribute("InterestedList",true);
        return "redirect:/requestProList";
        }
    }
    @RequestMapping("/changeRelation/{idT}")
    public String addRelation(@PathVariable("idT") Integer idT, HttpSession session){
        if(session.getAttribute("userName")==null)
            return "redirect:/ToLogin";
        else
            session.setAttribute("idT",idT);

        Integer idF=(Integer) session.getAttribute("UserId");
        if (relationService.isLike(idT,idF)){
            relationService.deleteRelation(idT,idF);
        }
        else
            relationService.addRelation(idT,idF);

        return "redirect:/ToProfile/"+idT;
    }
    @RequestMapping("/isliked")
    @ResponseBody
    public Boolean isliked(HttpSession session){
        int idF=(int) session.getAttribute("UserId");
        int idT=(int) session.getAttribute("idT");
        boolean isLike=relationService.isLike(idT,idF);
        session.removeAttribute("idT");
        return isLike;

    }
}
