package it.cettolin.cinema.service.interfaces;

import it.cettolin.cinema.dto.FilmDto;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FilmServiceInterface {

    List<FilmDto> getFilms();

    FilmDto getFilmById(Long id) throws BadRequestException;

    List<FilmDto> getFilmsByDate(Date startDate, Date endDate);

    void save(FilmDto filmDto);

}
