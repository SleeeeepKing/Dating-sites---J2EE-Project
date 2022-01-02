package com.example.j2ee_project.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationService {
    public boolean addRelation(int idT,int idF){
        //添加记录
        return true;
    }
    public List<Integer> SearchByIdTo(int idT){
        List<Integer> integerList= new ArrayList<Integer>();
    //返回关注列表
        return integerList;
    }
    public List<Integer> SearchByIdFrom(int idF){
        List<Integer> integerList= new ArrayList<Integer>();
    //返回被关注列表
        return integerList;
    }
    public boolean isLike(int idT,int idF){
        //确认对应记录是否存在
        return true;
    }
    public boolean deleteRelation(int idT,int idF){
        //删除对应记录
        return true;
    }

}
