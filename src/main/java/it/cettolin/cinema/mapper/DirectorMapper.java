package it.cettolin.cinema.mapper;

import it.cettolin.cinema.dto.DirectorDto;
import it.cettolin.cinema.model.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DirectorMapper {

    public DirectorDto directorToDirectorDto(Director regista) {
        return DirectorDto.builder()
                .id(regista.getId())
                .name(regista.getName())
                .surname(regista.getSurname())
                .build();
    }
}
