package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.ProfileEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/ToCreateProfile")
    public String ToCreateProfile(){
        return "create_profile";
    }
    @RequestMapping("/CreateProfile")
    public String CreateProfile(ProfileEntity profileEntity){
        return "index";
    }
    @RequestMapping("/ToProfile")
    public String ToProfile(){
        return "view_profile";
    }
}
