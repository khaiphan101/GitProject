package com.project.livestockfarmbe.model.news;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type_of_news")
public class TypeOfNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "typeOfNews")
    @JsonBackReference
    private List<News> newsList ;

    public TypeOfNews() {
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setRealEstateNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public TypeOfNews(Long id, String name) {
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
        return "typeOfnews{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
