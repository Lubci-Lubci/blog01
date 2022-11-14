package de.awacademy.blog.service;

import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloggerServiceImpl implements BloggerService {


    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public List<Blogger> getAllBloggers() {
        //return null;
        return bloggerRepository.findAll(); // Select
    }

    @Override
    public void saveBlogger(Blogger blogger) {
        this.bloggerRepository.save(blogger);
    }                           // INSERT

    @Override
    public Blogger getBloggerById(long id) {
        Optional<Blogger> optional = this.bloggerRepository.findById(id);
        Blogger blogger = null;

        if(optional.isPresent()){
            blogger = optional.get();
        } else {
            throw new RuntimeException("Blogger with id " + id + " was not found");
        }

        return blogger;
    }

    @Override
    public void editBloggerById(long id) {

    }

    @Override
    public void deleteBloggerById(long id) {
        this.bloggerRepository.deleteById(id);
    }
}
