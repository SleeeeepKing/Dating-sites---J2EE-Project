package com.example.j2ee_project.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "profile", schema = "j2eeproject", catalog = "")
public class ProfileEntity {
    private int idProfile;
    private String name;
    private int age;
    private Double weight;
    private Integer height;
    private String education;
    private String introduction;
    private String maritalStatus;
    private String city;
    private String photoPath;
    private String gender;

    @Id
    @Column(name = "idProfile")
    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Weight")
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "Education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "Introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "MaritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity that = (ProfileEntity) o;
        return idProfile == that.idProfile && age == that.age && Objects.equals(name, that.name) && Objects.equals(weight, that.weight) && Objects.equals(height, that.height) && Objects.equals(education, that.education) && Objects.equals(introduction, that.introduction) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile, name, age, weight, height,education, introduction, maritalStatus, city);
    }

    @Basic
    @Column(name = "photoPath")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "idProfile=" + idProfile +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", education='" + education + '\'' +
                ", introduction='" + introduction + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", city='" + city + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
