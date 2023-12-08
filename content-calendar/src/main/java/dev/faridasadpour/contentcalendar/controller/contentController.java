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
import dev.faridasadpour.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class contentController {
    private final ContentCollectionRepository repository;

    public contentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Content> findAll() {
        System.out.println("we got to getmapping!!!$$$");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Content findContent(@PathVariable Integer id) {
        return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    // @DeleteMapping("/{id}") 
    // void deletContent(@PathVariable Integer id) {
    //     repository.deletContent(id);
    // }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Content content) {
        System.out.println(" we got to postmapping!!!!");
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.delet(id);
    }
}
