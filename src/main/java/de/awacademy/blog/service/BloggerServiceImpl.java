package de.awacademy.blog.service;

import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloggerServiceImpl implements BloggerService {


    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public List<Blogger> getAllBloggers() {
        return null;
    }

    @Override
    public void saveBlogger(Blogger blogger) {

    }

    @Override
    public Blogger getBloggerById(long id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {

    }
}
