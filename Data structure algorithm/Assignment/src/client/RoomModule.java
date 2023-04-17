/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedList;
import adt.ListInterface;
import entity.PrivateRoom;
import entity.Room;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Desmond Lim Chiang Shen 
 */
public class RoomModule {

    public void userRoom(ListInterface<Room> roomList, ListInterface<Room> custRoom) {

        int roomSelect = 0;
        Scanner sc = new Scanner(System.in);
        while (roomSelect != 5) {
            System.out.print("\n");
            System.out.println("\t\t\t\t\t\t ____/|_KARAOKE|\\___");
            System.out.println("\t\t\t\t\t\t|                    |");
            System.out.println("\t\t\t\t\t\t|        ROOM        |");
            System.out.println("\t\t\t\t\t\t|____________________|");
            System.out.println("\t\t\t\t\t\t| 1. Join Room       |");
            System.out.println("\t\t\t\t\t\t| 2. Create Room     |");
            System.out.println("\t\t\t\t\t\t| 3. Close Room      |");
            System.out.println("\t\t\t\t\t\t| 4. Update Room     |");
            System.out.println("\t\t\t\t\t\t|____________________|");
            System.out.print("\t\t\t\t\t\t Select (1-4) : ");
            roomSelect = sc.nextInt();

            switch (roomSelect) {
                case 1:
                    joinRoom(roomList, custRoom);
                    roomSelect = 5;
                    break;
                case 2:
                    customerCreateRoom(roomList, custRoom);
                    backToPrevious();
                    break;
                case 3:
                    customerCloseRoom(roomList, custRoom);
                    backToPrevious();
                    break;
                case 4:
                    customerUpdateRoom(roomList, custRoom);
                    backToPrevious();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice !");
                    break;

            }
        }
    }

    public void joinRoom(ListInterface<Room> r, ListInterface<Room> c) {
        int i = 1;
        boolean found = false;
        boolean valid = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);

        viewRoom(r); 
        while(!found){
            Iterator<Room> join = r.getIterator();
            System.out.println("\nPlease enter the room id that you want to join: ");
            int keyin = ki.nextInt();
            while (join.hasNext() && !found) {
                room = join.next();
                //System.out.print(room);
                if (room.getRoomID() == keyin) {
                    found = true;
                    if(room instanceof PrivateRoom == false){
                        System.out.println("\nThe room of " + keyin + " is " + room.getRoomType());
                            room.setRoomCapacity(room.getRoomCapacity() - 1);
                            System.out.println("Joined successfully!");
                    }
                    else if (room instanceof PrivateRoom) {
                        while (!valid) {
                            System.out.println("\nPlease key in the room Code to join");
                            String k = inp.nextLine();

                            if (k.equals(((PrivateRoom) room).getRoomCode())) {
                                room.setRoomCapacity(room.getRoomCapacity() - 1);
                                System.out.println("Joined successfully!");
                                valid = true;
                            } else {
                                System.out.println("\nInvalid Room Code!");
                                System.out.println("Please try again.");
                            }
                        }
                    }
                    i++;
                }
            }
            if(!found){
                System.out.println("\nInvalid Room ID");
                System.out.println("Please try again.");
            }
        }
    }

    public void customerCreateRoom(ListInterface<Room> r, ListInterface<Room> c) {
        int roomchoice = 0;
        ListInterface<Room> roomList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n");
        System.out.println("\t\t\t\t\t\t ___/|_KARAOKE|\\____");
        System.out.println("\t\t\t\t\t\t|                    |");
        System.out.println("\t\t\t\t\t\t|     Create Room    |");
        System.out.println("\t\t\t\t\t\t|____________________|");
        System.out.println("\t\t\t\t\t\t| 1. Public Room     |");
        System.out.println("\t\t\t\t\t\t| 2. Private Room    |");
        System.out.println("\t\t\t\t\t\t|____________________|");
        System.out.print("\t\t\t\t\t\t Select (1-2) : ");
        roomchoice = sc.nextInt();

        if (roomchoice == 1) {

            Scanner scp = new Scanner(System.in);

            System.out.print("\n");
            System.out.println("===KARAOKE====");
            System.out.println("||           ||");
            System.out.println("||Create Room||");
            System.out.println("||  PUBLIC   ||");
            System.out.println("===============");

            System.out.print("\n");
            System.out.print("Room ID: ");
            int roomId = scp.nextInt();
            String roomName = scp.nextLine();
            System.out.print("Room Name: ");
            roomName = scp.nextLine();
            System.out.print("Room Capacity: ");
            int roomCapacity = scp.nextInt();
            System.out.print("Room Type: Public Room");
            System.out.print("\n");
            r.add(new Room(roomId, roomName, roomCapacity, "Public Room"));
            c.add(new Room(roomId, roomName, roomCapacity, "Public Room"));
        } else if (roomchoice == 2) {

            Scanner scp = new Scanner(System.in);

            System.out.print("\n");
            System.out.println("===KARAOKE====");
            System.out.println("||           ||");
            System.out.println("||Create Room||");
            System.out.println("||  PRIVATE  ||");
            System.out.println("===============");

            System.out.print("\n");
            System.out.print("Room ID: ");
            int roomId = scp.nextInt();
            String roomName = scp.nextLine();
            System.out.print("Room Name: ");
            roomName = scp.nextLine();
            System.out.print("Room Capacity: ");
            int roomCapacity = scp.nextInt();
            scp.nextLine();
            System.out.print("Room Type: Private Room");
            System.out.print("\nRoomCode: ");
            String roomCode = scp.nextLine();
            System.out.print("\n");
            r.add(new PrivateRoom(roomId, roomName, roomCapacity, "Private Room", roomCode));
            c.add(new PrivateRoom(roomId, roomName, roomCapacity, "Private Room", roomCode));
        } else {
            System.out.println("Invalid choice !, please try again !");
        }

    }

    public void customerCloseRoom(ListInterface<Room> r, ListInterface<Room> c) {
        int i = 1;
        boolean found = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);
        if (c.isEmpty()) {
            System.out.println("\nYou have not created any room yet. You can only remove the room that created by yourself.");
        } else {
            viewRoom(c);
            Iterator<Room> close1 = c.getIterator();
            Iterator<Room> close2 = r.getIterator();

            System.out.println("Please key in the room id to close the room");
            int keyin = ki.nextInt();

            while (close1.hasNext() && !found) {
                room = close1.next();
                //System.out.print(room);
                if (room.getRoomID() == keyin) {
                    found = true;
                    System.out.println("\nThe following room is closed and will be removed from the room list: \n" + c.remove(i));
                }
                i++;
            }

            found = false;
            int j = 1;
            while (close2.hasNext() && !found) {
                room = close2.next();
                //System.out.print(room);
                if (room.getRoomID() == keyin) {
                    found = true;
                    r.remove(j);
                }
                j++;
            }
        }
    }

    public  void customerUpdateRoom(ListInterface<Room> r, ListInterface<Room> c) {
        int i = 1;
        boolean found = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);
        Scanner select = new Scanner(System.in);
        if (c.isEmpty()) {
            System.out.println("\nYou have not created any room yet. You can only update the room that created by yourself.");
        } else {
            viewRoom(c);
            int roomchoice = 0;
            String roomName;
            int roomCapacity;
            Room newRoom = null;
            String roomCode;
            Scanner scp = new Scanner(System.in);

            Iterator<Room> update1 = c.getIterator();
            Iterator<Room> update2 = r.getIterator();
            System.out.println("Please key in the room id to update the room details");
            int keyin = ki.nextInt();
            while (update1.hasNext() && !found) {
                room = update1.next();
                if (room.getRoomID() == keyin) {

                    found = true;
                    System.out.println("what room type u want to create");
                    System.out.println("\t\t\t\t\t\t ___/|_KARAOKE|\\____");
                    System.out.println("\t\t\t\t\t\t|                    |");
                    System.out.println("\t\t\t\t\t\t|     Create Room    |");
                    System.out.println("\t\t\t\t\t\t|____________________|");
                    System.out.println("\t\t\t\t\t\t| 1. Public Room     |");
                    System.out.println("\t\t\t\t\t\t| 2. Private Room    |");
                    System.out.println("\t\t\t\t\t\t|____________________|");
                    System.out.print("\t\t\t\t\t\t Select (1-2) : ");
                    roomchoice = select.nextInt();

                    if (roomchoice == 1) {

                        System.out.print("\n");
                        System.out.println("===KARAOKE====");
                        System.out.println("||           ||");
                        System.out.println("||Create Room||");
                        System.out.println("||  PUBLIC   ||");
                        System.out.println("===============");

                        System.out.print("\n");
                        System.out.println("Room ID: " + keyin);
                        System.out.print("Room Name: ");
                        roomName = scp.nextLine();
                        System.out.print("Room Capacity: ");
                        roomCapacity = scp.nextInt();
                        System.out.print("Room Type: Public Room");
                        System.out.print("\nRoomCode:-");
                        System.out.print("\n");
                        newRoom = new Room(keyin, roomName, roomCapacity, "Public Room");
                        c.replace(i, newRoom);
                    } else if (roomchoice == 2) {

                        System.out.print("\n");
                        System.out.println("===KARAOKE====");
                        System.out.println("||           ||");
                        System.out.println("||Create Room||");
                        System.out.println("||  PRIVATE  ||");
                        System.out.println("===============");

                        System.out.print("\n");
                        System.out.println("Room ID: " + keyin);
                        System.out.print("Room Name: ");
                        roomName = scp.nextLine();
                        System.out.print("Room Capacity: ");
                        roomCapacity = scp.nextInt();
                        scp.nextLine();
                        System.out.print("Room Type: Private Room");
                        System.out.print("\nRoom Code: ");
                        roomCode = scp.nextLine();
                        System.out.print("\n");
                        newRoom = new PrivateRoom(keyin, roomName, roomCapacity, "Private Room", roomCode);
                        c.replace(i, newRoom);

                    } else {
                        System.out.println("Invalid choice !, please try again !");
                        found = true;
                    }
                } else {
                    System.out.println("Invalid choice, please try again !");
                    found = true;
                }
                i++;
            }

            int j = 1;
            found = false;
            while (update2.hasNext() && !found) {
                room = update2.next();
                if (room.getRoomID() == keyin) {
                    found = true;
                    r.replace(j, newRoom);
                }
                j++;
            }
        }

    }

    public static void custRoom(ListInterface<Room> r) {

    }

    public static boolean backToPrevious() {
        Scanner sc = new Scanner(System.in);
        boolean back = false;
        char input;
        do {
            System.out.print("\nEnter 'Y' to go back to previos menu: ");
            input = sc.next().charAt(0);
            if (input == 'Y'||input=='y') {
                back = true;
                return back;
            } else {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        } while (input != 'Y');
        return true;
    }

    public static void viewRoom(ListInterface<Room> r){  
       
        System.out.println("===========================================================");
        System.out.println("======================== KARAOKE ==========================");
        System.out.println("=======================  Room List  =======================");
        System.out.println("===========================================================");
        System.out.printf("%-10s%-20s%-15s%-15s\n","Room ID","Room Name","Room Capacity","Room Type");
        System.out.println("===========================================================");
        System.out.println(r);
    
    }
    
    public void roomMaintenance(ListInterface<Room> roomList) {

        boolean valid = false;
        while (!valid) {
            Scanner sc = new Scanner(System.in);
            int roomSelect = 0;
            System.out.print("\n");
            System.out.println("\t\t\t\t\t\t ____/|_KARAOKE|\\___");
            System.out.println("\t\t\t\t\t\t|                    |");
            System.out.println("\t\t\t\t\t\t|        ROOM        |");
            System.out.println("\t\t\t\t\t\t|____________________|");
            System.out.println("\t\t\t\t\t\t| 1. Search Room     |");
            System.out.println("\t\t\t\t\t\t| 2. Create Room     |");
            System.out.println("\t\t\t\t\t\t| 3. Close Room      |");
            System.out.println("\t\t\t\t\t\t| 4. Update Room     |");
            System.out.println("\t\t\t\t\t\t| 5. View Room       |");
            System.out.println("\t\t\t\t\t\t| 6. Room Report     |");
            System.out.println("\t\t\t\t\t\t| 7. Back            |");
            System.out.println("\t\t\t\t\t\t|____________________|");
            System.out.print("\t\t\t\t\t\t Select (1-7) : ");
            roomSelect = sc.nextInt();

            switch (roomSelect) {
                case 1:
                    searchRoom(roomList);
                    valid = !backToPrevious();
                    break;
                case 2:
                    RoomTypeSelection(roomList);
                    valid = !backToPrevious();
                    break;
                case 3:
                    closeRoom(roomList);
                    valid = !backToPrevious();
                    break;
                case 4:
                    updateRoom(roomList);
                    valid = !backToPrevious();
                    break;
                case 5:
                    viewRoom(roomList);
                    valid = !backToPrevious();
                    break;
                case 6:

                    roomReport(roomList);
                    valid = !backToPrevious();
                    break;
                case 7:
                    valid = true;
                    break;

                default:

                    System.out.println("Invalid choice !");
                    break;

            }
        }
    }

    public static void searchRoom(ListInterface<Room> r) {
        int i = 1;
        boolean found = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);

        viewRoom(r);
        Iterator<Room> search = r.getIterator();
        System.out.println("Please key in the room id to search the room");
        int keyin = ki.nextInt();
        while (search.hasNext() && !found) {
            room = search.next();
            //System.out.print(room);
            if (room.getRoomID() == keyin) {
                found = true;
                System.out.println("\nThe room of " + keyin + ": \n" + r.getEntry(i));
            }
            i++;
        }
    }

    public static void RoomTypeSelection(ListInterface<Room> r) {
        int roomchoice = 0;
        Scanner sc = new Scanner(System.in);
        Scanner scp = new Scanner(System.in);

        System.out.print("\n");
        System.out.println("\t\t\t\t\t\t ___/|_KARAOKE|\\____");
        System.out.println("\t\t\t\t\t\t|                    |");
        System.out.println("\t\t\t\t\t\t|     Create Room    |");
        System.out.println("\t\t\t\t\t\t|____________________|");
        System.out.println("\t\t\t\t\t\t| 1. Public Room     |");
        System.out.println("\t\t\t\t\t\t| 2. Private Room    |");
        System.out.println("\t\t\t\t\t\t|____________________|");
        System.out.print("\t\t\t\t\t\t Select (1-2) : ");
        roomchoice = sc.nextInt();

        if (roomchoice == 1) {

            System.out.print("\n");
            System.out.println("===KARAOKE====");
            System.out.println("||           ||");
            System.out.println("||Create Room||");
            System.out.println("||  PUBLIC   ||");
            System.out.println("===============");

            System.out.print("\n");
            System.out.print("Room ID: ");
            int roomId = scp.nextInt();
            String roomName = scp.nextLine();
            System.out.print("Room Name: ");
            roomName = scp.nextLine();
            System.out.print("Room Capacity: ");
            int roomCapacity = scp.nextInt();
            System.out.print("Room Type: Public Room");
            System.out.print("\nRoomCode:-");
            System.out.print("\n");
            r.add(new Room(roomId, roomName, roomCapacity, "Public Room"));
        } else if (roomchoice == 2) {

            System.out.print("\n");
            System.out.println("===KARAOKE====");
            System.out.println("||           ||");
            System.out.println("||Create Room||");
            System.out.println("||  PRIVATE  ||");
            System.out.println("===============");

            System.out.print("\n");
            System.out.print("Room ID: ");
            int roomId = scp.nextInt();
            String roomName = scp.nextLine();
            System.out.print("Room Name: ");
            roomName = scp.nextLine();
            System.out.print("Room Capacity: ");
            int roomCapacity = scp.nextInt();
            scp.nextLine();
            System.out.print("Room Type: Private Room");
            System.out.print("\nRoomCode: ");
            String roomCode = scp.nextLine();
            System.out.print("\n");
            r.add(new PrivateRoom(roomId, roomName, roomCapacity, "Private Room", roomCode));

        } else {
            System.out.println("Invalid choice !, please try again !");
        }

    }

    public static void closeRoom(ListInterface<Room> r) {
        int i = 1;
        boolean found = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);
        viewRoom(r);
        Iterator<Room> close = r.getIterator();
        System.out.println("Please key in the room id to close the room");
        int keyin = ki.nextInt();
        while (close.hasNext() && !found) {
            room = close.next();
            //System.out.print(room);
            if (room.getRoomID() == keyin) {
                found = true;
                System.out.println("\nThe following room is closed and will be removed from the room list: \n" + r.remove(i));
            }
            i++;
        }
    }

    public static void updateRoom(ListInterface<Room> r) {
        int i = 1;
        boolean found = false;
        Room room = null;
        Scanner ki = new Scanner(System.in);
        Scanner select = new Scanner(System.in);
        viewRoom(r);
        int roomchoice = 0;
        Scanner scp = new Scanner(System.in);

        Iterator<Room> update = r.getIterator();
        System.out.println("Please key in the room id to update the room details");
        int keyin = ki.nextInt();
        while (update.hasNext() && !found) {
            room = update.next();
            if (room.getRoomID() == keyin) {
                System.out.println("what room type u want to create");
                System.out.println("\t\t\t\t\t\t __/|___KARAOKE__|\\__");
                System.out.println("\t\t\t\t\t\t|                    |");
                System.out.println("\t\t\t\t\t\t|     Create Room    |");
                System.out.println("\t\t\t\t\t\t|____________________|");
                System.out.println("\t\t\t\t\t\t| 1. Public Room     |");
                System.out.println("\t\t\t\t\t\t| 2. Private Room    |");
                System.out.println("\t\t\t\t\t\t|____________________|");
                System.out.print("\t\t\t\t\t\t Select (1-2) : ");
                roomchoice = select.nextInt();

                if (roomchoice == 1) {

                    System.out.print("\n");
                    System.out.println("===KARAOKE====");
                    System.out.println("||           ||");
                    System.out.println("||Create Room||");
                    System.out.println("||  PUBLIC   ||");
                    System.out.println("===============");

                    System.out.print("\n");
                    System.out.println("Room ID: " + keyin);
                    System.out.print("Room Name: ");
                    String roomName = scp.nextLine();
                    System.out.print("Room Capacity: ");
                    int roomCapacity = scp.nextInt();
                    System.out.print("Room Type: Public Room");
                    System.out.print("\nRoomCode:-");
                    System.out.print("\n");
                    Room newRoom = new Room(keyin, roomName, roomCapacity, "Public Room");
                    r.replace(i, newRoom);
                } else if (roomchoice == 2) {

                    System.out.print("\n");
                    System.out.println("===KARAOKE====");
                    System.out.println("||           ||");
                    System.out.println("||Create Room||");
                    System.out.println("||  PRIVATE  ||");
                    System.out.println("===============");

                    System.out.print("\n");
                    System.out.println("Room ID: " + keyin);
                    System.out.print("Room Name: ");
                    String roomName = scp.nextLine();
                    System.out.print("Room Capacity: ");
                    int roomCapacity = scp.nextInt();
                    scp.nextLine();
                    System.out.print("Room Type: Private Room");
                    System.out.print("\nRoom Code: ");
                    String roomCode = scp.nextLine();
                    System.out.print("\n");
                    Room newRoom = new PrivateRoom(keyin, roomName, roomCapacity, "Private Room", roomCode);
                    r.replace(i, newRoom);

                } else {
                    System.out.println("Invalid choice !, please try again !");
                    found = true;
                }
            }
            i++;
        }
    }

    public static void roomReport(ListInterface<Room> r) {
        ListInterface<Room> publicRoom = new LinkedList<>();
        ListInterface<Room> privateRoom = new LinkedList<>();

        Scanner ki = new Scanner(System.in);
        Room room = null;

        Iterator<Room> report = r.getIterator();

        while (report.hasNext()) {
            room = report.next();
            if (room.getRoomType().equals("Public Room")) {
                publicRoom.add(room);
            } else if (room.getRoomType().equals("Private Room")) {
                privateRoom.add(room);
            }
        }

        System.out.printf("\n%-28s: %4d", "Total Number of the Room", r.getNumberOfEntries());
        System.out.printf("\n%-28s: %4d", "Total Number of Public Room", publicRoom.getNumberOfEntries());
        System.out.printf("\n%-28s: %4d", "Total Number of Private Room", privateRoom.getNumberOfEntries());
        System.out.print("\n");

    }


    public void roomList(ListInterface<Room> r) {

        r.add(new Room(1001, "3L1K", 10, "Public Room"));
        r.add(new Room(1002, "KaraoKe King", 5, "Public Room"));
        r.add(new Room(1006, "David Room", 4, "Public Room"));
        r.add(new Room(1007, "3K", 5, "Public Room"));

        r.add(new PrivateRoom(1003, "LK", 6, "Private Room", "1234"));
        r.add(new PrivateRoom(1004, "Jas", 5, "Private Room", "1234"));
        r.add(new PrivateRoom(1005, "J5R", 30, "Private Room", "1234"));
        r.add(new PrivateRoom(1008, "handsome", 8, "Private Room", "1234"));

    }
}
