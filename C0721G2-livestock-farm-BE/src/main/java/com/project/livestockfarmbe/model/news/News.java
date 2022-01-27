package com.project.livestockfarmbe.model.news;

import com.project.livestockfarmbe.customid.CustomIdGenerator;
import com.project.livestockfarmbe.model.employee.Employee;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "news")
@SQLDelete(sql = "UPDATE news SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
    @GenericGenerator(
            name = "news_seq",
            strategy = "com.project.livestockfarmbe.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "N-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime postDate;
    @ManyToOne(targetEntity = TypeOfNews.class)
    private TypeOfNews typeOfNews;
    private String image;
    private Boolean deleted = Boolean.FALSE;

    public News() {
    }

    public News(String id, Employee employee, String title, String content, LocalDateTime postDate, TypeOfNews typeOfNews, String image, Boolean deleted) {
        this.id = id;
        this.employee = employee;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.typeOfNews = typeOfNews;
        this.image = image;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public TypeOfNews getTypeOfNews() {
        return typeOfNews;
    }

    public void setTypeOfNews(TypeOfNews typeOfNews) {
        this.typeOfNews = typeOfNews;
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
        return "News{" +
                "id='" + id + '\'' +
                ", employee=" + employee +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                ", typeOfNews=" + typeOfNews +
                ", image='" + image + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
