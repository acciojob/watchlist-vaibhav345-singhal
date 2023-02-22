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
    private HashMap<String, List<String>> moviesWithDirector;


    MovieRepository() {
        this.movies = new HashMap<>();
        this.directors = new HashMap<>();
        this.moviesWithDirector = new HashMap<>();
    }

    public void addMovieRepo(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirectorRepo(Director director) {
        directors.put(director.getName(), director);
    }

    public void addMovieWithDirectorRepo(String name, String movie) {
        List<String> list;
        if (movies.containsKey(movie) && directors.containsKey(name)) {
            if (moviesWithDirector.containsKey(name)) {
                list = moviesWithDirector.get(name);
            } else {
                list = new ArrayList<>();
            }
            list.add(movie);
            moviesWithDirector.put(name, list);
        }
    }

    public Director getDirectorByNameRepo(String name) {
        return directors.getOrDefault(name, null);
    }


    public Movie getMovieByNameRepo(String name) {
        return movies.getOrDefault(name, null);
    }

    public List<String> getMoviesByDirectorNameRepo(String name) {
        return moviesWithDirector.getOrDefault(name, null);
    }

    public List<String> findAllMovieRepo() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Movie> movie : movies.entrySet()) {
            list.add(movie.getKey());
        }
        return list;
    }

    public void deleteALlDirectorRepo() {
        for (Map.Entry<String, List<String>> movie : moviesWithDirector.entrySet()) {
            List<String> list = movie.getValue();
            for (String film : list) {
                if (movies.containsKey(film)) movies.remove(film);
            }
            String dirName = movie.getKey();
            moviesWithDirector.remove(dirName);
            if (directors.containsKey(dirName)) directors.remove(dirName);
        }
    }

    public void deleteDirectorByNameRepo(String name) {
        if (directors.containsKey(name)) directors.remove(name);
        if (moviesWithDirector.containsKey(name)) {
            for (String movieName : moviesWithDirector.get(name)) {
                if (movies.containsKey(movieName)) movies.remove(movieName);
            }
            moviesWithDirector.remove(name);
        }
    }
}
