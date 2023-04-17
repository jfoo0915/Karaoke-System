/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Desmond Lim Chiang Shen
 */
public class PrivateRoom extends Room {

    private String roomCode;

    public PrivateRoom(int roomID, String roomName, int roomCapacity, String roomType, String roomCode) {
        super(roomID, roomName, roomCapacity, roomType);
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
