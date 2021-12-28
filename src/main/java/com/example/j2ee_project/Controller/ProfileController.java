package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.ProfileEntity;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


@Controller
public class ProfileController {

    @RequestMapping("/uploadPhoto")
    public String upload(MultipartFile photo, HttpSession session) throws IOException {
        String fileName=photo.getOriginalFilename();
        ServletContext servletContext=session.getServletContext();
        System.out.println("files name"+fileName);
        String photoPath=servletContext.getRealPath("photo");


        String finalPath=photoPath+File.separator+fileName;
        System.out.println("finalPath name"+finalPath);
        photo.transferTo(new File(finalPath));
        session.setAttribute("photoName",fileName);
        return "redirect:/ToCreateProfile";
    }
    @RequestMapping("/ToCreateProfile")
    public String ToCreateProfile(HttpSession session){
        if(session.getAttribute("userName")!=null)
        return "create_profile";
        else
            return "redirect:/ToLogin";
    }
    @RequestMapping("/CreateProfile")
    public String CreateProfile(ProfileEntity profileEntity,HttpSession session){
        if(session.getAttribute("photoName")!=null)
            profileEntity.setPhotoPath("photo/"+(String) session.getAttribute("photoName"));
        else
            profileEntity.setPhotoPath("images/default.png");
        System.out.println("Pro-info"+profileEntity);
        //将前端获取的资料对象，新建或保存，取决于session.hasPro
        return "index";
    }
    @RequestMapping("/ToModifierProfile")
    public ModelAndView ModifierProfile(HttpSession session){
        ProfileEntity profileEntity=new ProfileEntity();
        profileEntity.setName("zd");
        profileEntity.setCity("Nice");
        profileEntity.setHeight(123);
        profileEntity.setWeight(50.0);
        profileEntity.setAge(25);
        profileEntity.setEducation("sqdfqsdf");
        profileEntity.setIntroduction("sqdfqsdfzefqsdf");
        session.setAttribute("isModify",true);
        ModelAndView mav=new ModelAndView();
        mav.addObject(profileEntity);
        //从session获取用户名，然后获取资料对象传递给前端
        mav.setViewName("create_profile");

        return mav;
    }
    @RequestMapping("/ToProfile")
    public String ToProfile(){
        return "view_profile";
    }
}
