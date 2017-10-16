package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent Room class.
 */
@Entity
@Table(name = "rooms")
public class Room {

    /**
     * Room id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    /**
     * Room number.
     */
    @Column
    private int myRoomNumber;

    /**
     * Room Capacity
     */
    private int myCapacity;

    /**
     * Default Constructor
     */
    public Room(){
        this.myRoomNumber = 0;
    }

    public Room(final int roomNumber, int roomCapacity) {

        if (roomNumber < 0) {
           throw new IllegalArgumentException("Stay positive");
        } else {
            myRoomNumber = roomNumber;
        }

        if(roomCapacity < 0){
            throw new IllegalArgumentException("Stay positive");
        } else {
            myCapacity = roomCapacity;
        }
    }


    /**
     * Sets the id of the room.
     * @param id New id for the room
     */
    public void setId(final long id) {
        if (id > 0) {
            myId = id;
        }
    }

    /**
     * Returns the id number of the room.
     * @return id number of the room
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the name of the room.
     * @param roomNumber New roomNumber of the room.
     * @throws IllegalArgumentException if new roomNumber is blank
     */
    public void setRoomNumber(final int roomNumber) throws IllegalArgumentException {
        if (roomNumber < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            myRoomNumber = roomNumber;
        }
    }

    /**
     * Returns the name of the room.
     * @return Name of the room
     */
    public int getRoomNumber() {
        return myRoomNumber;
    }

    /**
     * Returns the capacity of the room.
     * @return Capacity of the room
     */
    public int getRoomCapacity() { return myCapacity; }

    /**
     * toString method for Room.
     */
    @Override
    public String toString() {
        return "Building{" + "Id=" + myId + ", Title= " + myRoomNumber + " }";
}
}


