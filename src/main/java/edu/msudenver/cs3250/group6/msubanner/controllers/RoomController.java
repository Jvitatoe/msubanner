package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * The controller for the room class.
 */
@RestController
public class RoomController {

    /**
     * The room service.
     */
    @Autowired
    private RoomService roomService;

    /**
     * Gets the list of all rooms.
     *
     * @return the list of all rooms
     */
    @RequestMapping("/rooms")
    public List<Room> getAllRooms() {

        return roomService.getAllRooms();
    }

    /**
     * Gets a room by id number.
     *
     * @param id the room id
     * @return the room
     */
    @RequestMapping("/rooms/getroom/{id}")
    public Room getRoom(@PathVariable final long id) {
        return roomService.getRoom(id);
    }

    /**
     * Adds a room.
     * @param room the room to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/rooms/addroom")
    public ResponseEntity<Room> addRoom(@RequestParam final int roomNumber, int roomCapacity) {
        Room room = new Room(roomNumber, roomCapacity);
        roomService.addRoom(room);
        return new ResponseEntity<Room>(room, HttpStatus.CREATED);
    }

    /**
     * Updates a course.
     *
     * @param room the room to be updated
     * @param id     the room's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/rooms/updateroom/{id}")
    public void updateRoom(@RequestBody final Room room,
                           @PathVariable final long id) {
        roomService.updateRoom(room);
    }

    /**
     * Deletes a course.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/rooms/deleteroom/{id}")
    public void deleteRoom(@PathVariable final long id) {
        roomService.deleteRoom(id);
    }
}
