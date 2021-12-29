package com.example.j2ee_project.DAO;

import javax.persistence.*;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();


        try{
            transaction.begin();


            transaction.commit();

        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}
