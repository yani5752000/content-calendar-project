package dev.faridasadpour.contentcalendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.faridasadpour.contentcalendar.model.Content;
import dev.faridasadpour.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class contentController {
    // private final ContentCollectionRepository repository;
    // private final ContentJdbcTemplateRepository repository;
    private final ContentRepository repository;

    // public contentController(ContentCollectionRepository repository) {
    //     this.repository = repository;
    // }
    // public contentController(ContentJdbcTemplateRepository repository) {
    //     this.repository = repository;
    // }
     public contentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Content> findAll() {
        System.out.println("we got to getmapping!!!$$$");
        return repository.findAll();
        //return repository.findAllContetnts();
    }

    @GetMapping("/{id}")
    Content findContent(@PathVariable Integer id) {
        return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
        //return repository.findById(id);
    }

    // @DeleteMapping("/{id}") 
    // void deletContent(@PathVariable Integer id) {
    //     repository.deletContent(id);
    // }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Content content) {
        // System.out.println(" we got to postmapping!!!!");
        // System.out.println(content.title());
        // System.out.println(content.desc());
        // System.out.println(content.status());
        // System.out.println(content.contentType());
        // System.out.println(content.url());
        repository.save(content);
        //repository.createContent(content.title(), content.desc(), content.status().toString(), content.contentType().toString(), content.url());
    }
    // void create(@Valid @RequestBody Content content) {
    //     System.out.println(" we got to postmapping!!!!");
    //     System.out.println(content.title());
    //     //repository.save(content);
    //     repository.createContent(content.title());
    // }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);

        //repository.updateContent(id, content.title(), content.desc(), content.status().toString(), content.contentType().toString(), content.url());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.deleteById(id);
    }
}
