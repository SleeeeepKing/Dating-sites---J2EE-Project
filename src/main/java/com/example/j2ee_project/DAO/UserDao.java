package com.example.j2ee_project.DAO;


import com.example.j2ee_project.Model.UserEntity;

import javax.persistence.*;
import java.util.List;

public class UserDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    //Done
    public int addUser(UserEntity user) {
        try {
            transaction.begin();
            Query addUser = entityManager.createNativeQuery("INSERT INTO user values (null ,+" + user.getUserName() + "," + user.getPassword() + "," + user.getEmail());
//            Query addUser = entityManager.createNativeQuery("INSERT INTO user values ('' ,'user03','123456','123@123.com') ");
            addUser.executeUpdate();//受影响的行数（插入的行数）
            transaction.commit();
            return 1;//if flag!=0, success
        } catch (Exception e) {
            return 0;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    //Done
    public List<UserEntity> searchById(int id) {
        try {
            transaction.begin();
            Query searchById = entityManager.createNativeQuery("select * from user where id = "+ id ,UserEntity.class);
            transaction.commit();
            List<UserEntity> userList = searchById.getResultList();
            return userList;
        } catch (Exception e) {
            return null;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
