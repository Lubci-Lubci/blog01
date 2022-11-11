package de.awacademy.blog.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
@Table(name = "bloggers")
public class Blogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name can't be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Name can't be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Login can't be empty")
    @Column (name = "login")
    private String Login;

    @NotEmpty(message = "Password can't be empty")
    @Column(name = "password")
    private String Password;

    @Email(message = "Email patter is not correct")
    @NotEmpty(message = "Name can't be empty")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Age can't be empty")
    @Column(name = "age")
    //@Pattern(^\d{1,2}$)
    private int Age;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date createdDate;


    public Blogger() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
