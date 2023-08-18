package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private IMovieClient iMovieClient;

    @GetMapping("catalog/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }

    @PostMapping("catalog/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    @GetMapping("/catalog/find")
    public ResponseEntity<String> find() {
        return ResponseEntity.ok(iMovieClient.find());
    }
}
