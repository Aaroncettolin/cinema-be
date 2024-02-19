package it.cettolin.cinema.service.interfaces;

import it.cettolin.cinema.dto.DirectorDto;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorServiceInterface {

    List<DirectorDto> getDirectors();

    DirectorDto getDirectorById(Long id) throws BadRequestException;

}
