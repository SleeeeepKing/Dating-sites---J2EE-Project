package com.example.j2ee_project.Service;

import com.example.j2ee_project.Model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //autowired UserDao
    public int login(UserEntity user){
        // 登录，返回用户id
        return 0;
    }
    public int register(UserEntity user){
        // 注册，返回用户id
        return 0;
    }

}
