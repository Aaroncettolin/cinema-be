package it.cettolin.cinema.mapper;

import it.cettolin.cinema.dto.RoomDto;
import it.cettolin.cinema.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomMapper {

    public RoomDto roomToRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .capacity(room.getCapacity())
                .isIMax(room.getIsIMax())
                .build();
    }
}
