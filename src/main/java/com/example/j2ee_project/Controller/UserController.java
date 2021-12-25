package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {
    @RequestMapping("/ToLogin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("/Login")
    public String Login(String username,String password){
        return "index";
    }
    @RequestMapping("/ToRegister")
    public String ToRegister(){
        return "register";
    }
    @RequestMapping("/Register")
    public String Register(UserEntity userEntity){
        return "index";
    }
    @RequestMapping("/Logout")
    public String Logout(){
        return "index";
    }
    @RequestMapping("/Home")
    public String Home(){
        return "index";
    }
}
