package de.awacademy.blog.service;

import de.awacademy.blog.model.Blogger;

import java.util.List;

public interface BloggerService {

    List<Blogger> getAllBloggers();

    void saveBlogger(Blogger blogger);

    Blogger getBloggerById(long id);

    void deleteEmployeeById(long id);



}
