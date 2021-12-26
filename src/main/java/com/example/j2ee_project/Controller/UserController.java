package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.UserEntity;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/ToLogin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("/Login")
    public String Login(UserEntity userEntity, HttpServletRequest request){

        UserEntity userI=new UserEntity();
        userI.setUserName("Dusan");
        userI.setUserName("123");
        System.out.println(userEntity);
        if(userEntity.getPassword()==userI.getPassword()){
            HttpSession httpSession= request.getSession();

            httpSession.setAttribute("userName",userEntity.getUserName());
            httpSession.setAttribute("login",true);}

        return "index";
    }
    @RequestMapping("/ToRegister")
    public String ToRegister(){
        return "register";
    }
    @RequestMapping("/Register")
    public String Register(UserEntity userEntity,HttpServletRequest request){
        HttpSession httpSession= request.getSession();

        httpSession.setAttribute("userName",userEntity.getUserName());
        httpSession.setAttribute("login",true);

        return "index";
    }
    @RequestMapping("/Logout")
    public String Logout( HttpServletRequest request){
            request.getSession().removeAttribute("login");
            request.getSession().removeAttribute("userName");
        return "index";
    }
    @RequestMapping("/Home")
    public String Home(){
        return "index";
    }
}
