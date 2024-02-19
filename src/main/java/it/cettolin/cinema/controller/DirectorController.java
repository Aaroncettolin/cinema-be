package it.cettolin.cinema.controller;

import it.cettolin.cinema.dto.DirectorDto;
import it.cettolin.cinema.service.interfaces.DirectorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorServiceInterface directorService;

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getRegistaById(@PathVariable("id") Long id) throws BadRequestException {
        try {
            return ResponseEntity.ok(directorService.getDirectorById(id));
        } catch (BadRequestException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getDirectors());
    }

}
