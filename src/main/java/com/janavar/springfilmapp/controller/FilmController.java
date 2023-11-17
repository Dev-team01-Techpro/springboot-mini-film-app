package com.janavar.springfilmapp.controller;

import com.janavar.springfilmapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("films")
@CrossOrigin(origins = "http://localhost:5500")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // !!! Get All Films


    // !!! CREATE a new Film


    // !!! GET a new Film


    // !!! DELETE Film


    // !!! UPDATE Film




}
