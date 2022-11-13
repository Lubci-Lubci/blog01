package de.awacademy.blog.controller;

import de.awacademy.blog.model.Article;
import de.awacademy.blog.model.Blogger;
import de.awacademy.blog.service.ArticleService;
import de.awacademy.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BloggerController {
    private BloggerService bloggerService;
    private ArticleService articleService;

    @Autowired
    public BloggerController(BloggerService bloggerService, ArticleService articleService) {
        this.bloggerService = bloggerService;
        this.articleService = articleService;
    }

    @GetMapping("/")
    @ResponseBody
    public String hello(@RequestParam(required = false, defaultValue = "Guest ", name = "login") String Login){

    return Login.isEmpty() ? "Hello guest" : "Hello " + Login;
    }

    /* ----------------------   Blogger (users / admins) stuff   ----------------------*/
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
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "bloggers/new";
        }

        bloggerService.saveBlogger(blogger);

        return "redirect:/bloggers";
    }


    @GetMapping("/bloggers/showFormForEdit/{id}")
    public String showFormForEdit(@PathVariable(value = "id") long id, Model model){
        Blogger blogger = bloggerService.getBloggerById(id);

        model.addAttribute("blogger", blogger);
        return "/bloggers/edit";
    }

    @GetMapping("bloggers/showFormForDelete/{id}")
    public String showFormForDelete(@PathVariable(value = "id") long id){
        bloggerService.deleteBloggerById(id);

        return "redirect:/bloggers";
    }

/* ----------------------   Article stuff   ----------------------*/

    @GetMapping("/articles")
    public String articlesHome(Model model){
        List<Article> articles = articleService.getAllArticles();
        articles = articles.stream().sorted(Comparator.comparing(Article::getId).reversed())    // chronological order (newest first)
                        .collect(Collectors.toList());
        model.addAttribute("listOfArticles", articles);

        return "articles/index";
    }

    @GetMapping("/articles/showNewArticleForm")
    public String showNewArticleForm(Model model){
        model.addAttribute("article", new Article());
        return "articles/new";
    }

    @PostMapping("/articles/saveArticle")
    public String saveArticle(@Valid @ModelAttribute Article article,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "articles/new";
        }
        articleService.saveArticle(article);

        return "redirect:/articles";
    }

    @GetMapping("/articles/showFormForEdit/{id}")
    public String showFormForEditArticle(@PathVariable(value = "id") long id, Model model){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "articles/edit";
    }

    @GetMapping("articles/showFormForDeleteArticle/{id}")
    public String showFormForDeleteArticle(@PathVariable(value = "id") long id){
        bloggerService.deleteBloggerById(id);

        return "redirect:/articles";
    }

    @GetMapping("/articles/showFormForRead/{id}")
    public String showFormForReadArticle(@PathVariable(value = "id") long id, Model model){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "articles/read";
    }
}