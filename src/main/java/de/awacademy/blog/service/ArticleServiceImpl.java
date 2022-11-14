package de.awacademy.blog.service;

import de.awacademy.blog.model.Article;
import de.awacademy.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        this.articleRepository.save(article);
    }

    @Override
    public Article getArticleById(long id) {
        Optional<Article> optional = this.articleRepository.findById(id);
        Article article = null;

        return article;
    }

    @Override
    public void deleteArticleById(long id) {
        this.articleRepository.deleteById(id);
    }

    @Override
    public void editArticleByID(long id) {

    }

}
