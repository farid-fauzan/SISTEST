package com.sis.rest.services;

import com.sis.rest.entity.Movies;
import com.sis.rest.pojo.MoviePojo;
import com.sis.rest.respository.MovieRepository;
import com.sis.rest.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServices {

    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity all() {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            List<Movies> list = movieRepository.findAll();
            if (list.size()>0){
                msg.setStatus(true);
                msg.setMessage("Berhasil Get Data!");
                msg.setData(list);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity findById(Long id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Movies movies = movieRepository.findByid(id);
            if (movies!=null){
                msg.setStatus(true);
                msg.setMessage("Berhasil Get Data!");
                msg.setData(movies);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity add(MoviePojo moviePojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Movies movies = new Movies();
            movies.setTitle(moviePojo.getTitle());
            movies.setDescription(moviePojo.getDescription());
            movies.setImage(moviePojo.getDescription());
            movies.setRating(moviePojo.getRating());
            movies.setCreatedt(moviePojo.getCreatedt());
            movies.setUpdatedAt(moviePojo.getUpdatedAt());
            movieRepository.save(movies);

            msg.setStatus(true);
            msg.setMessage("Berhasil Save Data!");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity update(Long id, MoviePojo moviePojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Movies movies = new Movies();
            movies.setId(id);
            movies.setTitle(moviePojo.getTitle());
            movies.setDescription(moviePojo.getDescription());
            movies.setImage(moviePojo.getDescription());
            movies.setRating(moviePojo.getRating());
            movies.setCreatedt(moviePojo.getCreatedt());
            movies.setUpdatedAt(moviePojo.getUpdatedAt());
            movieRepository.save(movies);

            msg.setStatus(true);
            msg.setMessage("Berhasil Update Data!");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity delete(Long id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            movieRepository.deleteById(id);

            msg.setStatus(true);
            msg.setMessage("Berhasil Delete Data!");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }



}
