package com.janavar.springfilmapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Film adi bos olamaz!")
    @Size(min = 2, max = 50, message = "Film adi '${validatedValue}' {min} ve {max} arasinda olmali!")
    @Column(nullable = false, length = 50)
    private String filmName;

    @NotBlank(message = "Film yili bos olamaz!")
    // TODO : 4 KARAKTER AYARI Json format arastir
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Size(min = 3, max = 5, message = "Yapim yili'${validatedValue}' {min} ve {max} arasinda olmali!")
    @Column(length = 5)
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapimcisi bos olamaz!")
    @Size(min = 2, max = 20, message = "Film yapimcisi '${validatedValue}' {min} ve {max} arasinda olmali!")
    @Column(nullable = false, length = 20)
    private String producer;

    @NotBlank(message = "Film turu bos olamaz!")
    @Size(min = 2, max = 25, message = "Filmin turu '${validatedValue}' {min} ve {max} arasinda olmali!")
    @Column(nullable = false, length = 25)
    private String genre;
}
