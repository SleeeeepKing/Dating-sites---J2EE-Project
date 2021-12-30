package com.example.j2ee_project.DAO;

import com.example.j2ee_project.Model.Condition;
import com.example.j2ee_project.Model.ProfileEntity;

import javax.persistence.*;
import java.util.List;

public class ProfileDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    //Done
    public List<ProfileEntity> searchByConditions(Condition condition) {
        try {
            transaction.begin();
            Query searchByConditions = entityManager.createNativeQuery("select * from profile where gender= \'" + condition.getGender() + "\' and city= \'" + condition.getLocate() + "\' and Age >=" + condition.getAgeF() + " and Age<=" + condition.getAgeT() + " and MaritalStatus= \'" + condition.getStatus()+"\'", ProfileEntity.class);
            transaction.commit();
            List<ProfileEntity> profileEntities = searchByConditions.getResultList();
            return profileEntities;
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
    public int addProfile(ProfileEntity profileEntity) {//
        try {
            transaction.begin();
//            Query addProfile = entityManager.createNativeQuery("INSERT INTO profile values (3,'zhangsan','19','28','181','edu','intro','Status','City','photo','gender') ");
            Query addProfile = entityManager.createNativeQuery("INSERT INTO profile values (" + profileEntity.getIdProfile() + "," + profileEntity.getName() + "," + profileEntity.getAge() + "," + profileEntity.getWeight() + "," + profileEntity.getHeight() + "," + profileEntity.getEducation() + "," + profileEntity.getIntroduction() + "," + profileEntity.getMaritalStatus() + "," + profileEntity.getCity() + "," + profileEntity.getPhotoPath() + "," + profileEntity.getGender());
            addProfile.executeUpdate();
            transaction.commit();
            return 1;
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
    public boolean updateProfile(ProfileEntity profileEntity) {//
        try {
            transaction.begin();
//            Query updateProfile = entityManager.createNativeQuery("UPDATE profile set Name='AfterUpdate',Age='99',Weight='99',Height=null,Education='',Introduction='',MaritalStatus='',City='',photoPath='',gender='' where idProfile=1");
            Query updateProfile = entityManager.createNativeQuery("UPDATE profile set Name=" + profileEntity.getName() + ",Age=" + profileEntity.getAge() + ",Weight=" + profileEntity.getWeight() + ",Height=" + profileEntity.getHeight() + ",Education=" + profileEntity.getEducation() + ",Introduction=" + profileEntity.getIntroduction() + ",MaritalStatus=" + profileEntity.getMaritalStatus() + ",City=" + profileEntity.getCity() + ",photoPath=" + profileEntity.getPhotoPath() + ",gender=" + profileEntity.getGender() + " where idProfile=" + profileEntity.getIdProfile());
            updateProfile.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    //Done
    public boolean deleteProfile(int id) {
        try {
            transaction.begin();
            Query deleteProfile = entityManager.createNativeQuery("delete from profile where idProfile=" + id);
            deleteProfile.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    //Done
    public List<ProfileEntity> searchById(int id) {
        try {
            transaction.begin();
            Query searchById = entityManager.createNativeQuery("select * from profile where profile.idProfile =" + id, ProfileEntity.class);
            List<ProfileEntity> profileEntities = searchById.getResultList();
            transaction.commit();
            return profileEntities;
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
