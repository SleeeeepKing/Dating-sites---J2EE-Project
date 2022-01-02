package com.example.j2ee_project.Controller;

import com.example.j2ee_project.Model.Condition;
import com.example.j2ee_project.Model.ProfileEntity;
import com.example.j2ee_project.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProfileController {
    @Autowired private ProfileService profileService;
    @RequestMapping("/uploadPhoto")
    public String upload(MultipartFile photo, HttpSession session) throws IOException {
        String fileName=photo.getOriginalFilename();
        ServletContext servletContext=session.getServletContext();
        //System.out.println("files name"+fileName);
        String photoPath=servletContext.getRealPath("photo");


        String finalPath=photoPath+File.separator+fileName;
        //System.out.println("finalPath name"+finalPath);
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
        if((boolean)session.getAttribute("hasPro"))
            profileService.Update(profileEntity);
        else
            profileService.creatProfile(profileEntity);
        session.setAttribute("hasPro",true);
        //将前端获取的资料对象，新建或保存，取决于session.hasPro
        return "redirect:/Home";
    }
    @RequestMapping("/deleteProfile")
    public String deleteProfile(HttpSession session){
        profileService.deleteProfile((int)session.getAttribute("Userid"));
        session.setAttribute("hasPro",false);
        return "redirect:/Home";
    }

    @RequestMapping("/ToModifierProfile")
    public ModelAndView ModifierProfile(HttpSession session){
        ProfileEntity profileEntity=profileService.getProfile((int)session.getAttribute("UserId"),true).get(0);

        session.setAttribute("isModify",true);
        ModelAndView mav=new ModelAndView();
        mav.addObject(profileEntity);
        //从session获取用户名，然后获取资料对象传递给前端
        mav.setViewName("create_profile");

        return mav;
    }
    @RequestMapping("/requestProList")
    public ModelAndView profileEntities(HttpSession session,
                                        @RequestParam(value = "Gender",required = false) String Gender,
                                        @RequestParam(value = "locate",required = false) String locate,
                                        @RequestParam(value = "ageF",required = false,defaultValue = "0") Integer ageF,
                                        @RequestParam(value = "ageT",required = false,defaultValue = "0") Integer ageT,
                                        @RequestParam(value = "Status",required = false) String Status){
        List<ProfileEntity> profileEntities=new ArrayList<ProfileEntity>();
        Condition condition=new Condition();
        condition.setGender(Gender);
        condition.setLocate(locate);
        condition.setAgeF(ageF);
        condition.setAgeT(ageT);
        condition.setStatus(Status);
        System.out.println(condition);
       if(session.getAttribute("InterestedList")!=null){
           profileEntities=profileService.getProfile((int)session.getAttribute("UserId"),false);
           session.removeAttribute("InterestedList");
       }
        else{
            if(session.getAttribute("UserId")!=null)
                profileEntities=profileService.SearchByCondition(condition,(int)session.getAttribute("UserId"));
            else
            {
                profileEntities=profileService.SearchByCondition(condition,0);

            }}

        ModelAndView mav=new ModelAndView();
        mav.addObject("profileEntities",profileEntities);
        mav.setViewName("matches");
        return mav;

    }
    @RequestMapping("/ToProfile/{id}")
    public ModelAndView ToProfile(@PathVariable("id") Integer id){
        ProfileEntity profileEntity=profileService.getProfile(id,true).get(0);
        ModelAndView mav=new ModelAndView();
        mav.addObject("profile",profileEntity);
        mav.setViewName("view_profile");

        return mav;
    }
}
