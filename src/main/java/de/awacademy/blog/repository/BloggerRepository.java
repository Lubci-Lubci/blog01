package de.awacademy.blog.repository;

import de.awacademy.blog.model.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggerRepository extends JpaRepository<Blogger, Long> {
}
