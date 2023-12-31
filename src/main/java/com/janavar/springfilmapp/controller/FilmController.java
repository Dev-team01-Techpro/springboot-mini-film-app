package com.janavar.springfilmapp.controller;

import com.janavar.springfilmapp.domain.Film;
import com.janavar.springfilmapp.dto.FilmDTO;
import com.janavar.springfilmapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
@CrossOrigin(origins = "http://localhost:5500")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // !!! Get All Films
    @GetMapping //http://localhost:8080/films + GET
    public ResponseEntity<List<Film>> listAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
        //return new ResponseEntity<>(films, HttpStatus.OK);
    }

    // !!! CREATE a new Film
    @PostMapping //http://localhost:8080/films + POST + JSON
    public ResponseEntity<Map<String, String>> createFilm(@Valid @RequestBody Film film) {
        filmService.createNewFilm(film);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Film basariyla eklendi");
        map.put("status", "true");
        //HttpStatus Code = 201
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // !!! CREATE new Films
    @PostMapping("/films") //http://localhost:8080/films + POST + JSON
    public ResponseEntity<Map<String, String>> createFilms(@Valid @RequestBody List<Film> films) {
        filmService.createNewFilms(films);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Filmler basariyla eklendi");
        map.put("status", "true");
        //HttpStatus Code = 201
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // !!! GET a Film
    @GetMapping("/{id}") //http://localhost:8080/films/1 + GET
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(filmService.findFilm(id));
    }

    // !!! DELETE Film
    @DeleteMapping("/{id}")//http://localhost:8080/films/1 + DELETE
    public ResponseEntity<String> deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilm(id);
        String message = "Film başarıyla silindi.";
        return new ResponseEntity<>(message, HttpStatus.OK);//200
    }

    // !!! UPDATE Film
    @PutMapping("/{id}")  ////http://localhost:8080/films/1 + PUT + JSON
    public ResponseEntity<String> updateFilm(@PathVariable("id") Long id, @Valid @RequestBody FilmDTO filmDTO) {
        filmService.updateFilm(id, filmDTO);
        String message = "Film başarıyla güncellendi.";
        return new ResponseEntity<>(message, HttpStatus.OK);//200
    }

}
