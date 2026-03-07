package com.capgemini.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Event;

import ch.qos.logback.core.spi.ConfigurationEvent.EventType;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventDateGreaterThanEqual(LocalDate date);

    List<Event> findByEventType(EventType type);

    List<Event> findByTitleContainingIgnoreCase(String title);
}