/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;


import adt.AdtSet;
import adt.LinkedList;
import adt.LinkedQueue;
import adt.ListInterface;
import adt.QueueInterface;
import adt.SetInterface;
import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Member;
import entity.Admin;
import entity.Room;
import entity.PlayListDetails;
import entity.Playlist;
import entity.Song;
import client.RoomModule;
import client.Karaoke;
import client.SongMaintenance;
import client.MemberMainteanance;
import entity.PrivateRoom;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author Lim Zhen Foo, Lim Wen Jing, Ko Yun Xuan, Desmond Lim Chiang Shen 
 */
public class DriverProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SetInterface<Admin> admin = new AdtSet();
        createAdmin(admin);

        MemberMainteanance mmbrModule = new MemberMainteanance();
        RoomModule rm = new RoomModule();
        Karaoke karaokeSession = new Karaoke();
        SongMaintenance song = new SongMaintenance();
        
        //create member
        SetInterface<Member> member = new AdtSet();
        SetInterface<Member> memSpkMan = new AdtSet(); //member that speak mandarin only 
        SetInterface<Member> memSpkMly = new AdtSet(); //member that speak malay only 
        SetInterface<Member> memSpkEng = new AdtSet(); //member that speak english only 

        mmbrModule.createMember(member);
        mmbrModule.initMember(memSpkMan, memSpkMly, memSpkEng);

        //create song
        SortedListInterface<Song> songList = new SortedArrayList<>();
        
        song.createSongList(songList);

        //create room
        ListInterface<Room> roomList = new LinkedList<>();
        ListInterface<Room> custRoom = new LinkedList<>();
        rm.roomList(roomList);

        //singsession
        ListInterface<Playlist> playList = new LinkedList<>();
        QueueInterface<PlayListDetails> playlistDetails = new LinkedQueue<>();
        ListInterface<PlayListDetails> finishSing = new LinkedList<>();

        
        Scanner scanner = new Scanner(System.in);
        int mainMenuOption = 0;
        boolean end = false;
        boolean valid = false;
        do {
            mainMenu();
            System.out.print("\nPlease choose a number to proceed: ");
            mainMenuOption = scanner.nextInt();

            switch (mainMenuOption) {
                case 1: //Karaoke
                    rm.userRoom(roomList, custRoom);
                    karaokeSession.singSession(songList, playList, playlistDetails, finishSing);
                    end = true;
                    break;

                case 2: //Member Maintenance
                    if (valid) {

                        mmbrModule.memberModule(member, memSpkMan, memSpkMly, memSpkEng);
                    } else {
                        while (!valid) {
                            valid = login(admin);
                        }
                        mmbrModule.memberModule(member, memSpkMan, memSpkMly, memSpkEng);
                    }
                    break;

                case 3: // Song Maintenace 
                    if (valid) {
                        song.songMain(songList);
                    } else {
                        while (!valid) {
                            valid = login(admin);
                        }
                        song.songMain(songList);
                    }
                    break;
                case 4:  //Room maintenance
                    if (valid) {
                        rm.roomMaintenance(roomList);
                    } else {

                        while (!valid) {
                            valid = login(admin);
                        }
                        rm.roomMaintenance(roomList);
                    }
                    break;
                case 5:
                    end = true;
                    System.out.println("\n----Thank You!-----\n");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }

        } while (!end);
    }

    public static void createAdmin(SetInterface admin) {
        admin.add(new Admin("Lim", 'M', "0123456789", 1111));
    }

    public static boolean login(SetInterface admin) {
        Scanner scanner = new Scanner(System.in);
        Iterator<Admin> iterator = admin.getIterator();
        Admin cloneAdmin = iterator.next();
        System.out.println("\nLog in as admin ");
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.print("Enter password: ");
        int password = scanner.nextInt();
        if (id == cloneAdmin.getAdminId() && password == cloneAdmin.getPassword()) {
            return true;
        } else {
            System.out.println("Admin id is invalid or password is invalid");
            return false;
        }
    }

    public static void mainMenu() {
        System.out.println("\n****************");
        System.out.println("*  3L1Karaoke  *");
        System.out.println("****************");
        System.out.println("1. Karaoke");
        System.out.println("2. Member Maintenance");
        System.out.println("3. Song maintenance");
        System.out.println("4. Room maintenance");
        System.out.println("5. Exit");
    }

}
