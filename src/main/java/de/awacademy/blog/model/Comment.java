package de.awacademy.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "You could not post an empty article")
    @Column(name = "comment_text")
    private String commentText;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Date createdDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "blogger_id", nullable = false)
    private Blogger blogger;
    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

//    @ManyToMany(mappedBy = "comments")
//    private Set<Article> articles = new HashSet<>();

    public Comment() {
    }

    public Comment(String commentText, Blogger blogger, Article article) {
        this.commentText = commentText;
        this.blogger = blogger;
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentText() {

        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
