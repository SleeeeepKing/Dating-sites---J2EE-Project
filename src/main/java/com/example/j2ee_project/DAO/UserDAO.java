package com.example.j2ee_project.DAO;


import javax.persistence.*;



public class UserDAO {

    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public void add(){
        this.transaction.begin();
    }
    public void main(String[] args) {


        try{
            this.transaction.begin();






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
