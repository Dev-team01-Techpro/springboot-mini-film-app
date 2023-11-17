package com.janavar.springfilmapp.repository;

import com.janavar.springfilmapp.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
