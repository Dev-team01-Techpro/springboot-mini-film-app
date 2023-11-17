package com.janavar.springfilmapp.service;

import com.janavar.springfilmapp.domain.Film;
import com.janavar.springfilmapp.exception.ResourceNotFoundException;
import com.janavar.springfilmapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
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


    // Not : CREATE a new Film
    public Film findFilm(Long id) {

        return filmRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(id + "numaralı film bulunamadı.."));
    }

    // Not : GET a Film


    // Not : DELETE Film


    // Not : UPDATE Film




}
