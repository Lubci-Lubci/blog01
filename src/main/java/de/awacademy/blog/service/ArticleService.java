package de.awacademy.blog.service;

import de.awacademy.blog.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    void saveArticle(Article article);
    Article getArticleById(long id);
    void deleteArticleById(long id);
}
