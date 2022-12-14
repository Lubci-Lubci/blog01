package de.awacademy.blog.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;


@Entity
@Table(name = "bloggers")
public class Blogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Username could not be empty")
    @Column (name = "user_name")
    private String userName;

    @NotEmpty(message = "Password could not be empty")
    @Column(name = "password")
    private String password;

//    @Column(name = "admin")
//    private boolean admin;
    @OneToMany(mappedBy = "blogger")
    private List<Article> articleList = new ArrayList<>();

    @OneToMany(mappedBy = "blogger")
    private List<Comment> commentList = new ArrayList<>();

    @NotEmpty(message = "Name could not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Name could not be empty")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email patter is not correct")
    @NotEmpty(message = "Name could not be empty")
    @Column(name = "email")
    private String email;

//    @NotEmpty(message = "Age could not be empty")
//    @Column(name = "age")
//    //@Pattern(^\d{1,2}$)
//    private int age;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Date createdDate;

    public Blogger() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return userName;
    }

//    public void setLogin(String login) {
//        userName = login;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public boolean isAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(boolean admin) {
//        this.admin = admin;
//    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
