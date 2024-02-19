package it.cettolin.cinema.service.interfaces;

import it.cettolin.cinema.dto.RoomDto;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomServiceInterface {

    List<RoomDto> getRooms();

    RoomDto getRoomById(Long id) throws BadRequestException;

}
