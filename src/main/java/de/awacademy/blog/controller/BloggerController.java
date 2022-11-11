package de.awacademy.blog.controller;

import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/bloggers/showNewBloggerForm")
    public String showNewBloggerForm(Model model){
        model.addAttribute("blogger", new Blogger());

        return "bloggers/new";
    }

    @PostMapping("/bloggers/saveBlogger")
    public String saveBlogger(@Valid @ModelAttribute Blogger blogger,
                              BindingResult result){
        if (result.hasErrors()){
            return "bloggers/new";
        }

        bloggerService.saveBlogger(blogger);

        return "redirect:/bloggers";
    }

    @GetMapping("/bloggers/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Blogger blogger = bloggerService.getBloggerById(id);

        model.addAttribute("bloger", blogger);
        return "bloggers/update";
    }

    @GetMapping("bloggers/showFormForDelete/{id}")
    public String showFormForDelete(@PathVariable(value = "id") long id){
        bloggerService.deleteBloggerById(id);

        return "redirect:/bloggers";
    }




}
