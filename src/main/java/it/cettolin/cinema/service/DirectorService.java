package it.cettolin.cinema.service;

import it.cettolin.cinema.dto.DirectorDto;
import it.cettolin.cinema.mapper.DirectorMapper;
import it.cettolin.cinema.repository.DirectorRepository;
import it.cettolin.cinema.service.interfaces.DirectorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorService implements DirectorServiceInterface {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorDto> getDirectors() {
        return directorRepository.findAll().stream().map(directorMapper::directorToDirectorDto).collect(Collectors.toList());
    }

    @Override
    public DirectorDto getDirectorById(Long id) throws BadRequestException {
        var director = directorRepository.findById(id).orElseThrow(() -> new BadRequestException(
                "Director not existing"));

        return directorMapper.directorToDirectorDto(director);
    }

}
