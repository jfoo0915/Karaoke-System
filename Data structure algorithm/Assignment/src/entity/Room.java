/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * author Desmond Lim Chiang Shen
 */
public class Room {

    protected int roomID;
    protected String roomName;
    protected int roomCapacity;
    protected String roomType;

    public Room(int roomID) {
        this.roomID = roomID;
    }

    public Room(int roomID, String roomName, int roomCapacity, String roomType) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-20s%-15d%-15s", roomID, roomName, roomCapacity, roomType);
    }

}
