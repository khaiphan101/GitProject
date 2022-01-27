package com.project.livestockfarmbe.model.treatement;

import com.project.livestockfarmbe.customid.CustomIdGenerator;
import com.project.livestockfarmbe.model.individual.Individual;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "treatments")
@SQLDelete(sql = "UPDATE treatments SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Treatement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatment_seq")
    @GenericGenerator(
            name = "treatments_seq",
            strategy = "com.project.livestockfarmbe.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "TR-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime treatementDate;
    private String doctor;
    private String medicine;
    private String note;
    private String kindOfDisease;
    private int quantily;
    private Boolean deleted = Boolean.FALSE;
    @ManyToOne(targetEntity = Individual.class)
    private Individual individual;

    public Treatement() {
    }

    public Treatement(String id, LocalDateTime treatementDate, String doctor, String medicine, String note, String kindOfDisease, int quantily, Boolean deleted, Individual individual) {
        this.id = id;
        this.treatementDate = treatementDate;
        this.doctor = doctor;
        this.medicine = medicine;
        this.note = note;
        this.kindOfDisease = kindOfDisease;
        this.quantily = quantily;
        this.deleted = deleted;
        this.individual = individual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTreatementDate() {
        return treatementDate;
    }

    public void setTreatementDate(LocalDateTime treatementDate) {
        this.treatementDate = treatementDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKindOfDisease() {
        return kindOfDisease;
    }

    public void setKindOfDisease(String kindOfDisease) {
        this.kindOfDisease = kindOfDisease;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public String toString() {
        return "Treatement{" +
                "id='" + id + '\'' +
                ", treatementDate=" + treatementDate +
                ", doctor='" + doctor + '\'' +
                ", medicine='" + medicine + '\'' +
                ", note='" + note + '\'' +
                ", kindOfDisease='" + kindOfDisease + '\'' +
                ", quantily=" + quantily +
                ", deleted=" + deleted +
                ", individual=" + individual +
                '}';
    }
}
