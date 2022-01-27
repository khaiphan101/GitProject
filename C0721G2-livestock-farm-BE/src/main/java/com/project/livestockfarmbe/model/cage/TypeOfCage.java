package com.project.livestockfarmbe.model.cage;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type_of_cage")
public class TypeOfCage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "typeOfCage")
    @JsonBackReference
    private List<Cage> cageList ;

    public TypeOfCage() {
    }

    public List<Cage> getCageList() {
        return cageList;
    }

    public void setCageList(List<Cage> cageList) {
        this.cageList = cageList;
    }

    public TypeOfCage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "typeOfCage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
