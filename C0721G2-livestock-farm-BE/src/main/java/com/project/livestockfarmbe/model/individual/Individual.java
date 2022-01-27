package com.project.livestockfarmbe.model.individual;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.livestockfarmbe.customid.CustomIdGenerator;
import com.project.livestockfarmbe.model.cage.Cage;

import com.project.livestockfarmbe.model.treatement.Treatement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Entity(name = "inviduals")
@SQLDelete(sql = "UPDATE inviduals SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invidual_seq")
    @GenericGenerator(
            name = "invidual_seq",
            strategy = "com.project.livestockfarmbe.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "IN-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    @Column(name = "date_in", columnDefinition = "DATE")
    private LocalDate dateIn;
    @Column(name = "date_out", columnDefinition = "DATE")
    private LocalDate dateOut;
    private Double weight;
    @Column(name = "status", columnDefinition = "TINYINT")
    private Integer status;
    private Boolean deleted = Boolean.FALSE;
    @ManyToOne(targetEntity = Cage.class)
    private Cage cage;
    @OneToMany(mappedBy = "individual")
    @JsonBackReference
    private List<Treatement> treatementList;

    public Individual() {

    }

    public Individual(String id, LocalDate dateIn, LocalDate dateOut, Double weight, Integer status, Boolean deleted, Cage cage) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.weight = weight;
        this.status = status;
        this.deleted = deleted;
        this.cage = cage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "id='" + id + '\'' +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", weight=" + weight +
                ", status=" + status +
                ", deleted=" + deleted +
                ", cage=" + cage +
                ", treatementList=" + treatementList +
                '}';
    }
}
