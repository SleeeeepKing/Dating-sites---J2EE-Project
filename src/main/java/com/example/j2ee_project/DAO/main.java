package com.example.j2ee_project.DAO;

import Model.Condition;

public class main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.searchById(3));
        RelationDao relationDao=new RelationDao();
        ProfileDao profileDao=new ProfileDao();
//        System.out.println(profileDao.searchById(1));
        Condition condition = new Condition();
        condition.setAgeF(40);
        condition.setAgeT(60);
        condition.setGender("F");
        condition.setLocate("Paris");
        condition.setStatus("Single");
//        System.out.println(profileDao.searchByConditions(condition));
//        System.out.println(condition.getGender());
    }
}
