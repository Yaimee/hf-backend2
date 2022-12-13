package com.example.hfbackend2.news.controller;

import com.example.hfbackend2.news.service.NewsService;
import com.example.hfbackend2.news.model.News;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/news")
public class NewsController {

    private final NewsService service;

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<News> add(@Valid @RequestBody News object) {
        return ResponseEntity.ok().body(service.add(object));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<News> delete(@PathVariable("id") Long id) {
        News result = service.findById(id);
        service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> put (@PathVariable("id") Long id, @Valid @RequestBody News request){
        return ResponseEntity.ok().body(service.update(id, request, false));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<News> patch(@PathVariable("id") Long id, @Valid @RequestBody News object){
        return ResponseEntity.ok().body(service.update(id, object, true));
    }
}
