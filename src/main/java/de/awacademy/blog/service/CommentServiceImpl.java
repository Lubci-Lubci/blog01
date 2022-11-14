package de.awacademy.blog.service;

import de.awacademy.blog.model.Comment;
import de.awacademy.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        //return null;
        return commentRepository.findAll();  // Select
    }

    @Override
    public void saveComments(Comment comment) {
        this.commentRepository.save(comment);   // INSERT
    }

    @Override
    public Comment getCommentById(long id) {
        Optional<Comment> optional = this.commentRepository.findById(id);
        Comment comment = null;

        if(optional.isPresent()){
            comment = optional.get();
        } else {
            throw new RuntimeException("Comment with id " + id + " was not found");
        }

        return comment;
    }

    @Override
    public void editCommentById(long id) {

    }

    @Override
    public void deleteCommentById(long id) {
        this.commentRepository.deleteById(id);
    }
}
