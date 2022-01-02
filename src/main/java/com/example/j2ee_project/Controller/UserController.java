package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.UserEntity;
import com.example.j2ee_project.Service.ProfileService;
import com.example.j2ee_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired private UserService userService;
    @Autowired private ProfileService profileService;
    @RequestMapping("/Login")
    public String Login(UserEntity userEntity, HttpSession session){

        int id=userService.login(userEntity);
        System.out.println(userEntity);
        if(id!=0){
            session.setAttribute("userName",userEntity.getUserName());
            session.setAttribute("UserId",id);
            session.setAttribute("login",true);
            if(profileService.hasProfile(id))
        session.setAttribute("hasPro",true);
            else
                session.setAttribute("hasPro",false);
        //调用service判断是否有资料来决定该值
            }


        return "redirect:/Home";
    }

    @RequestMapping("/Register")
    public String Register(UserEntity userEntity,HttpSession session){


        session.setAttribute("userName",userEntity.getUserName());
        session.setAttribute("login",true);

        return "redirect:/Home";
    }
    @RequestMapping("/Logout")
    public String Logout( HttpSession session){
            session.removeAttribute("login");
            session.removeAttribute("userName");
        session.setAttribute("hasPro",false);
        return "redirect:/Home";
    }

}
