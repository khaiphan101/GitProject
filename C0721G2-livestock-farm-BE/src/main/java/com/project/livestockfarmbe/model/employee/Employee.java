package com.project.livestockfarmbe.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.livestockfarmbe.customid.CustomIdGenerator;
import com.project.livestockfarmbe.model.account.AppUser;
import com.project.livestockfarmbe.model.news.News;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "employees")
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @GenericGenerator(
            name = "employee_seq",
            strategy = "com.project.livestockfarmbe.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "NV-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @Column(name = "date_of_Birth", columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    private String idCard;
    @Column(name = "gender", columnDefinition = "TINYINT")
    private Integer gender;
    @OneToOne(targetEntity = AppUser.class)
    private AppUser appUser;
    private String image;
    private Boolean deleted = Boolean.FALSE;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<News> newsList;

    public Employee() {
        //this is a constructor
    }

    @SuppressWarnings("squid:S00107")
    public Employee(String id, String name, String email, String phoneNumber, String address, LocalDate dateOfBirth, String idCard, Integer gender, AppUser appUser, String image, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.gender = gender;
        this.appUser = appUser;
        this.image = image;
        this.deleted = deleted;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idCard='" + idCard + '\'' +
                ", gender=" + gender +
                ", appUser=" + appUser +
                ", image='" + image + '\'' +
                ", deleted=" + deleted +
                ", newsList=" + newsList +
                '}';
    }
}
