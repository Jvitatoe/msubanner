package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    /**
     * Gets the list of all courses.
     * @return the list of all courses
     */
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    /**
     * Gets a course by id.
     * @param id the course id
     * @return the course
     */
    public Room getRoom(final long id) {
        return roomRepository.findOne(id);
    }

    /**
     * Adds a room.
     * @param room the room to add
     */
    public void addRoom(final Room room) {
        roomRepository.save(room);
    }

    /**
     * Updates a room.
     * @param room the room to update
     */
    public void updateRoom(final Room room) {
        roomRepository.save(room);
    }

    /**
     * Deletes a room.
     * @param id the room id
     */
    public void deleteRoom(final long id) {
        roomRepository.delete(id);
    }

}
