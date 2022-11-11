package de.awacademy.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Title could not be empty")
    @NotNull
    @Column(name = "title")
    private String title;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date createdDate;

    @NotEmpty(message = "You could not post an empty article")
    @Column(name = "content")
    private String content;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "blogger_id", nullable = false)
//    private Blogger blogger;

    public Article() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
