package com.capgemini.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.UrlMapping;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    List<UrlMapping> findByCreatedAtAfter(LocalDateTime dateTime);

    @Query("SELECT u FROM UrlMapping u ORDER BY u.clickCount DESC LIMIT 5")
    List<UrlMapping> findTop5MostClickedUrls();
}