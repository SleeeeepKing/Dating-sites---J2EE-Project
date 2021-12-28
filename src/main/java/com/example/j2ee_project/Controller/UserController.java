package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.UserEntity;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping("/Login")
    public String Login(UserEntity userEntity, HttpSession session){

        UserEntity userI=new UserEntity();
        userI.setUserName("Dusan");
        userI.setPassword("123");
        System.out.println(userEntity);
        if(userEntity.getPassword().equals(userI.getPassword())){
            session.setAttribute("userName",userEntity.getUserName());
            session.setAttribute("login",true);
        session.setAttribute("hasPro",true);
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
