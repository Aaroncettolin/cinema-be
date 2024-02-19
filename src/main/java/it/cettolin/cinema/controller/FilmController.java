package it.cettolin.cinema.controller;

import it.cettolin.cinema.service.interfaces.FilmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmServiceInterface filmService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable("id") Long id) throws BadRequestException {
        try {
            return ResponseEntity.ok(filmService.getFilmById(id));
        } catch (BadRequestException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllFilmsByDate(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                           @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.ok(filmService.getFilmsByDate(startDate, endDate));
        } else {
            return ResponseEntity.ok(filmService.getFilms());
        }

    }

}