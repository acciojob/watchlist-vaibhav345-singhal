package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovieService(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirectorService(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name") String name, @RequestBody() Movie movie) {
        movieService.addMovieDirectorPairService(name, movie);
        return new ResponseEntity<>("success ", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
        Movie movie = movieService.getMovieByMovieName(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dirName) {
        Director director = movieService.getDirectorByNameService(dirName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("director") String name) {
        List<Movie> list = movieService.getMoviesByDirectorNameService(name);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> list = movieService.findAllMovieService();
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name) {
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteALlDirectorService();
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
