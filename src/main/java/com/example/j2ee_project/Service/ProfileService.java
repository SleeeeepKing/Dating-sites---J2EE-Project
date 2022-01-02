package com.example.j2ee_project.Service;

import com.example.j2ee_project.Model.Condition;
import com.example.j2ee_project.Model.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    //autowired ProfileDao,RelationDao
    public List<ProfileEntity> SearchByCondition(Condition condition,int id){
        List<ProfileEntity> profileEntities=new ArrayList<ProfileEntity>();
        // 根据条件返回列表，condition所有空值为任意匹配
        return profileEntities;
    }

    public boolean creatProfile(ProfileEntity profileEntity){
        // 创建记录
        return true;
    }

    public ProfileEntity Update(ProfileEntity profileEntity){
        // 更新记录
        return profileEntity;
    }

    public boolean deleteProfile(int id){
        // 删除记录
        return true;
    }

    public List<ProfileEntity> getProfile(int id){
        List<ProfileEntity> profileEntities=new ArrayList<ProfileEntity>();
        // 根据用户id 联合RelationService.searchbyidT，获得关注用户列表
        return  profileEntities;
    }

    public boolean hasProfile(int id){
        // 确认该用户是否有profile
        return true;
    }

}
