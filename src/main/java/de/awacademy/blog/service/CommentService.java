package de.awacademy.blog.service;

import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    void saveComment(Comment comment);


    Comment getCommentById(long id);

    void editCommentById(long id);

    void deleteCommentById(long id);
}
