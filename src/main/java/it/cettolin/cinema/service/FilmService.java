package it.cettolin.cinema.service;

import it.cettolin.cinema.dto.FilmDto;
import it.cettolin.cinema.mapper.FilmMapper;
import it.cettolin.cinema.repository.FilmRepository;
import it.cettolin.cinema.service.interfaces.FilmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService implements FilmServiceInterface {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    @Override
    public List<FilmDto> getFilms() {
        return filmRepository.findAll().stream().map(filmMapper::filmToFilmDto).collect(Collectors.toList());
    }

    @Override
    public FilmDto getFilmById(Long id) throws BadRequestException {
        var film = filmRepository.findById(id).orElseThrow(() -> new BadRequestException(
                "Film not existing"));

        return filmMapper.filmToFilmDto(film);

    }

    @Override
    public List<FilmDto> getFilmsByDate(Date startDate, Date endDate) {
        return filmRepository.findByStartDateBeforeAndEndDateAfter(endDate, startDate).stream().map(filmMapper::filmToFilmDto).collect(Collectors.toList());
    }

    @Override
    public void save(FilmDto filmDto) {
        filmRepository.save(filmMapper.filmDtoToFilm(filmDto));
    }

}
