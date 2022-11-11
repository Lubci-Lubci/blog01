package de.awacademy.blog.service;

import de.awacademy.blog.model.Blogger;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<Blogger> getAllBloggers();

    void saveBlogger(Blogger blogger);

    Blogger getBloggerById(long id);

    void deleteEmployeeById(long id);



}
