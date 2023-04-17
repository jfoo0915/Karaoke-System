/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lim Zhen Foo
 */
public class Member extends User {

    private static int nextId = 1000;
    private int memberId;
    private Room room;
    private int password;

    public Member() {
        this.memberId = nextId;
        nextId++;
    }

    public Member(String name, char gender, String contactNo, Room room, int password) {
        super(name, gender, contactNo);
        this.memberId = nextId;
        this.password = password;
        this.room = room;
        nextId++;
    }

    public Member(int memberId, String name, char gender, String contactNo, Room room, int password) {
        super(name, gender, contactNo);
        this.memberId = memberId;
        this.password = password;
        this.room = room;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Member.nextId = nextId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoomId(int roomId) {
        this.room = new Room(roomId);
    }

    public boolean equals(Object obj) {
        Member o = (Member) obj;
        if (o.getMemberId() == this.getMemberId()) {
            return true;
        }
        if (o.getName().equals(this.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ("\nMember ID:" + memberId + super.toString() + "Room ID: " + room.getRoomID() + "\nPassword: " + password);
    }

}
