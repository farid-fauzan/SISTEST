package com.sis.rest.controller;

import com.sis.rest.entity.Movies;
import com.sis.rest.pojo.MoviePojo;
import com.sis.rest.respository.MovieRepository;
import com.sis.rest.services.MovieServices;
import com.sis.rest.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Movies")
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/")
    public ResponseEntity<MessageModel> findAll() {

        return movieServices.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageModel> findById(@PathVariable Long id) {

        return movieServices.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<MessageModel> addMovie(@RequestBody MoviePojo movies) {

        return movieServices.add(movies);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MessageModel> update(@PathVariable Long id, @RequestBody MoviePojo movies) {
        return movieServices.update(id,movies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageModel> update(@PathVariable Long id) {
        return movieServices.delete(id);
    }

}
