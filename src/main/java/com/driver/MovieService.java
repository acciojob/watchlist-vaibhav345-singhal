package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repo;

    public void addMovieService(Movie movie) {
        repo.addMovieRepo(movie);
    }

    public void addDirectorService(Director director) {
        repo.addDirectorRepo(director);
    }

    public void addMovieDirectorPairService(String movie, String director) {
        repo.addMovieWithDirectorRepo(movie, director);
    }

    public Director getDirectorByNameService(String dirName) {
        return repo.getDirectorByNameRepo(dirName);
    }

    public Movie getMovieByMovieName(String name) {
        return repo.getMovieByNameRepo(name);
    }

    public List<String> getMoviesByDirectorNameService(String name) {
        return repo.getMoviesByDirectorNameRepo(name);
    }

    public List<String> findAllMovieService() {
        return repo.findAllMovieRepo();
    }

    public void deleteALlDirectorService() {
        repo.deleteALlDirectorRepo();
    }

    public void deleteDirectorByName(String name) {
        repo.deleteDirectorByNameRepo(name);
    }
}
