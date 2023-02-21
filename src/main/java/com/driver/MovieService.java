package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repo;

    void addMovieService(Movie movie) {
        repo.addMovieRepo(movie);
    }

    void addDirectorService(Director director) {
        repo.addDirectorRepo(director);
    }

    public void addMovieDirectorPairService(String name, Movie movie) {
        repo.addMovieWithDirectorRepo(name, movie);
    }

    public Director getDirectorByNameService(String dirName) {
        return repo.getDirectorByNameRepo(dirName);
    }

    public Movie getMovieByMovieName(String name) {
        return repo.getMovieByNameRepo(name);
    }

    public List<Movie> getMoviesByDirectorNameService(String name) {
        return repo.getMoviesByDirectorNameRepo(name);
    }

    public List<Movie> findAllMovieService() {
        return repo.findAllMovieRepo();
    }

    public void deleteALlDirectorService() {
        repo.deleteALlDirectorRepo();
    }

    public void deleteDirectorByName(String name) {
        repo.deleteDirectorByNameRepo(name);
    }
}
