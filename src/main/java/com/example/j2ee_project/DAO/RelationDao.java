package com.example.j2ee_project.DAO;

import javax.persistence.*;
import java.util.List;

public class RelationDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    //Done
    public int addRelation(int idF, int idT) {
        try {
            transaction.begin();
            Query addRelation = entityManager.createNativeQuery("INSERT INTO relation values (null,+" + idT + "," + idF + ")");
            addRelation.executeUpdate();//受影响的行数（插入的行数）
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
    public List<Integer> searchByIdF(int idF) {
        try {
            transaction.begin();
            Query searchByIdF = entityManager.createNativeQuery("select relation.idFollowTo from relation where relation.idFollowFrom =" + idF);
            transaction.commit();
            List<Integer> idT = searchByIdF.getResultList();
            return idT;
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

    //Done
    public List<Integer> searchByIdT(int idT) {
        try {
            transaction.begin();
            Query searchByIdT = entityManager.createNativeQuery("select relation.idFollowFrom from relation where relation.idFollowTo = " + idT);
            transaction.commit();
            List<Integer> idF = searchByIdT.getResultList();
            return idF;
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
