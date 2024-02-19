package it.cettolin.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDto {

    private Long id;
    private String name;
    private DirectorDto director;
    private Long directorId;
    private String note;
    private Date startDate;
    private Date endDate;
    private RoomDto room;
    private Long roomId;

}
