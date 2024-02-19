package it.cettolin.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {

    private Long id;
    private String roomName;
    private Boolean isIMax;
    private Integer capacity;

}
