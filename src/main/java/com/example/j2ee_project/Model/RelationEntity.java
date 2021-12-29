package com.example.j2ee_project.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "relation", schema = "j2eeproject", catalog = "")
public class RelationEntity {
    private int idRelation;
    private int idFollowTo;
    private int idFollowFrom;

    @Id
    @Column(name = "idRelation")
    public int getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(int idRelation) {
        this.idRelation = idRelation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationEntity that = (RelationEntity) o;
        return idRelation == that.idRelation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRelation);
    }

    @Basic
    @Column(name = "idFollowTo")
    public int getIdFollowTo() {
        return idFollowTo;
    }

    public void setIdFollowTo(int idFollowTo) {
        this.idFollowTo = idFollowTo;
    }

    @Basic
    @Column(name = "idFollowFrom")
    public int getIdFollowFrom() {
        return idFollowFrom;
    }

    public void setIdFollowFrom(int idFollowFrom) {
        this.idFollowFrom = idFollowFrom;
    }

    @Override
    public String toString() {
        return "RelationEntity{" +
                "idRelation=" + idRelation +
                ", idFollowTo=" + idFollowTo +
                ", idFollowFrom=" + idFollowFrom +
                '}';
    }
}
