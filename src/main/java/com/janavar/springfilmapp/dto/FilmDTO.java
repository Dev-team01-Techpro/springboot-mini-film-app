package com.janavar.springfilmapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.janavar.springfilmapp.domain.Film;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private Long id;

    @NotBlank(message = "Film adi bos olamaz!")
    @Size(min = 2, max = 50, message = "Film adi '${validatedValue}' {min} ve {max} arasinda olmali!")
    private String filmName;

    @NotBlank(message = "Film yili bos olamaz!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapimcisi bos olamaz!")
    @Size(min = 2, max = 20, message = "Film yapimcisi '${validatedValue}' {min} ve {max} arasinda olmali!")
    private String producer;

    @NotBlank(message = "Film turu bos olamaz!")
    @Size(min = 2, max = 25, message = "Filmin turu '${validatedValue}' {min} ve {max} arasinda olmali!")
    private String genre;

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.filmName = film.getFilmName();
        this.releaseYear = film.getReleaseYear();
        this.imdbRating = film.getImdbRating();
        this.producer =film.getProducer();
        this.genre = film.getGenre();
    }
}
