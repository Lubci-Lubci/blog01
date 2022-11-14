package de.awacademy.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "You could not post an empty article")
    @Column(name = "comment_text")
    private String commentText;



}
