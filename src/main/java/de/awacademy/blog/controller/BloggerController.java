package de.awacademy.blog.controller;

import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BloggerController {

    private BloggerService bloggerService;


    @Autowired
    public BloggerController(BloggerService bloggerService){
        this.bloggerService = bloggerService;
    }

    @GetMapping("/bloggers")
    public String bloggerHome(Model model){
        model.addAttribute("listOfBloggers", bloggerService.getAllBloggers());

        return "bloggers/index";
    }






}
