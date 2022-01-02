package com.example.j2ee_project.Model;


import javax.persistence.Entity;


public class Condition {
    private String Gender;
    private String locate;
    private int ageF;
    private int ageT;
    private String Status;

    public String getGender() {
        return Gender;
    }

    public String getLocate() {
        return locate;
    }

    public int getAgeF() {
        return ageF;
    }

    public int getAgeT() {
        return ageT;
    }

    public String getStatus() {
        return Status;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public void setAgeF(int ageF) {
        this.ageF = ageF;
    }

    public void setAgeT(int ageT) {
        this.ageT = ageT;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "Gender='" + Gender + '\'' +
                ", locate='" + locate + '\'' +
                ", ageF=" + ageF +
                ", ageT=" + ageT +
                ", Status='" + Status + '\'' +
                '}';
    }
}
