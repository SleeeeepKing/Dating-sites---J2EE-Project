package com.example.j2ee_project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "relation", schema = "j2eeproject", catalog = "")
public class RelationEntity {
    private int idRelation;

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
}
