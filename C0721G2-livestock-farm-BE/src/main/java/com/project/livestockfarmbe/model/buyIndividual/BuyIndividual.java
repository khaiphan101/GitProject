package com.project.livestockfarmbe.model.buyIndividual;

import com.project.livestockfarmbe.customid.CustomIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity(name = "buyIndividuals")
public class BuyIndividual {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatment_seq")
    @GenericGenerator(
            name = "treatments_seq",
            strategy = "com.project.livestockfarmbe.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "BI-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String content;

    public BuyIndividual(String id, String name, String email, String phoneNumber, String address, String content) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.content = content;
    }

    public BuyIndividual() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BuyIndividual{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
