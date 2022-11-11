package de.awacademy.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //@NotEmpty(message = "Name can't be empty")

    @Column
    private String Login;

    private String Password;

    private int Age;

}
