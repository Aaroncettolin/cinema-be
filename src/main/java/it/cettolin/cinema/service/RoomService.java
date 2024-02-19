package it.cettolin.cinema.service;

import it.cettolin.cinema.dto.RoomDto;
import it.cettolin.cinema.mapper.RoomMapper;
import it.cettolin.cinema.repository.RoomRepository;
import it.cettolin.cinema.service.interfaces.RoomServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService implements RoomServiceInterface {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream().map(roomMapper::roomToRoomDto).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long id) throws BadRequestException {
        var room = roomRepository.findById(id).orElseThrow(() -> new BadRequestException(
                "Room not existing"));

        return roomMapper.roomToRoomDto(room);

    }
}
