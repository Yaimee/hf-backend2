package com.example.hfbackend2.news.repository;

import com.example.hfbackend2.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
