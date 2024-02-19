package it.cettolin.cinema.mapper;

import it.cettolin.cinema.dto.FilmDto;
import it.cettolin.cinema.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilmMapper {

    private final RoomMapper roomMapper;
    private final DirectorMapper DirectorMapper;

    public FilmDto filmToFilmDto(Film film) {
        var filmDto = FilmDto.builder()
                .id(film.getId())
                .name(film.getName())
                .note(film.getNote())
                .endDate(film.getEndDate())
                .startDate(film.getStartDate())
                .build();

        if(film.getRoom() != null) {
            filmDto.setRoom(roomMapper.roomToRoomDto(film.getRoom()));
        }

        if(film.getDirector() != null) {
            filmDto.setDirector(DirectorMapper.directorToDirectorDto(film.getDirector()));
        }

        return filmDto;
    }

    public Film filmDtoToFilm(FilmDto filmDto) {
        var film = Film.builder()
                .id(filmDto.getId())
                .name(filmDto.getName())
                .note(filmDto.getNote())
                .endDate(filmDto.getEndDate())
                .startDate(filmDto.getStartDate())
                .build();

        if(film.getRoom() != null) {
            //film.setRoom(roomMapper.roomToRoomDto(filmDto.getRoomId())); eventuale check esistenza e inserimento, o diverso pattern
        }

        if(film.getDirector() != null) {
            //film.setDirector(); eventuale check esistenza e inserimento, o diverso pattern
        }

        return film;
    }
}
