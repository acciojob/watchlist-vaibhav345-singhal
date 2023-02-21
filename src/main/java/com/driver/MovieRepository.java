package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movies;
    private HashMap<String, Director> directors;
    private HashMap<String, List<Movie>> moviesWithDirector;

    private List<Movie> movieList;

    MovieRepository() {
        this.movies = new HashMap<>();
        this.directors = new HashMap<>();
        this.moviesWithDirector = new HashMap<>();
        this.movieList = new ArrayList<>();
    }

    void addMovieRepo(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    void addDirectorRepo(Director director) {
        directors.put(director.getName(), director);
    }

    void addMovieWithDirectorRepo(String name, Movie movie) {
        movieList.add(movie);
        moviesWithDirector.put(name, movieList);
    }

    Director getDirectorByNameRepo(String name) {
        return directors.getOrDefault(name, null);
    }


    public Movie getMovieByNameRepo(String name) {
        return movies.getOrDefault(name, null);
    }

    public List<Movie> getMoviesByDirectorNameRepo(String name) {
        return moviesWithDirector.getOrDefault(name, null);
    }

    public List<Movie> findAllMovieRepo() {
        return movieList;
    }

    public void deleteALlDirectorRepo() {
        for (Map.Entry<String, List<Movie>> movie : moviesWithDirector.entrySet()) {
            List<Movie> list = movie.getValue();
            for (Movie film : list) {
                if (movies.containsKey(film)) movies.remove(film);
            }
            String name = movie.getKey();
            moviesWithDirector.remove(name);
            if (directors.containsKey(name)) directors.remove(name);
        }
    }

    public void deleteDirectorByNameRepo(String name) {
        List<Movie> list = moviesWithDirector.get(name);

        for (Movie movie : list) {
            if (movies.containsKey(movie)) movies.remove(movie);
        }
        moviesWithDirector.remove(name);
        if (directors.containsKey(name)) directors.remove(name);
    }
}
