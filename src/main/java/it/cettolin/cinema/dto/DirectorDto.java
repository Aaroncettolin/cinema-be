package it.cettolin.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectorDto {

    private Long id;
    private String name;
    private String surname;

}
