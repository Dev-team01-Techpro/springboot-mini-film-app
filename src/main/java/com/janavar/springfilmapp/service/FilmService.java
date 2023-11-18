package com.janavar.springfilmapp.service;

import com.janavar.springfilmapp.domain.Film;
import com.janavar.springfilmapp.dto.FilmDTO;
import com.janavar.springfilmapp.exception.ResourceNotFoundException;
import com.janavar.springfilmapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    // Not : GET ALL FILMS
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Not : CREATE a new Film
    public void createNewFilm(Film film) {
        filmRepository.save(film);
    }

    // Not : GET a Film
    public Film findFilm(Long id) {
        return filmRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id + "numaralı film bulunamadı.."));
    }

    // Not : DELETE Film
    public void deleteFilm(Long id) {
        Film film = findFilm(id);
        filmRepository.delete(film);
    }

    // Not : UPDATE Film
    public void updateFilm(Long id, FilmDTO filmDTO) {
        Film film = findFilm(id);
        film.setFilmName(filmDTO.getFilmName());
        film.setReleaseYear(filmDTO.getReleaseYear());
        film.setImdbRating(filmDTO.getImdbRating());
        film.setProducer(filmDTO.getProducer());
        film.setGenre(filmDTO.getGenre());

        filmRepository.save(film);
    }
}
