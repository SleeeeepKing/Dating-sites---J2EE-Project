package com.example.j2ee_project.Model;

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
    private Date dataOfBrith;
    private String education;
    private String introduction;
    private String maritalStatus;
    private String city;

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
    @Column(name = "DataOfBrith")
    public Date getDataOfBrith() {
        return dataOfBrith;
    }

    public void setDataOfBrith(Date dataOfBrith) {
        this.dataOfBrith = dataOfBrith;
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
        return idProfile == that.idProfile && age == that.age && Objects.equals(name, that.name) && Objects.equals(weight, that.weight) && Objects.equals(height, that.height) && Objects.equals(dataOfBrith, that.dataOfBrith) && Objects.equals(education, that.education) && Objects.equals(introduction, that.introduction) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile, name, age, weight, height, dataOfBrith, education, introduction, maritalStatus, city);
    }
}
