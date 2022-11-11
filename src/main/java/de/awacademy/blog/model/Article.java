package de.awacademy.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Title could not be empty.")
    @NotNull
    @Column(name = "article_name")
    private String title;

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
}
