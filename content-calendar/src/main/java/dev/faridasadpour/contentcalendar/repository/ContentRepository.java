package dev.faridasadpour.contentcalendar.repository;

import org.springframework.data.repository.ListCrudRepository;

import dev.faridasadpour.contentcalendar.model.Content;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    
}
