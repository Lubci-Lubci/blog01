package de.awacademy.blog.repository;

import de.awacademy.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
