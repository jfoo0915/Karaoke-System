/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import adt.SortedListInterface;
import adt.ListInterface;
import java.util.Scanner;
import entity.Song;
import entity.Playlist;
import entity.PlayListDetails;
import java.util.Iterator;
import adt.QueueInterface;

/**
 *
 * @author Ko Yun Xuan
 * 
 */
public class Karaoke {


    public void singSession(SortedListInterface<Song> songList, ListInterface<Playlist> playList, QueueInterface<PlayListDetails> playlistDetails, ListInterface<PlayListDetails> finishSing) {

        // TODO code application logic here
        //Create and add songs to sorted list
        //playlistMenu();
        Scanner sc = new Scanner(System.in);

        boolean check = false;
        while (!check) {
            playlistMenu();
            int choice_playlist = sc.nextInt();
            switch (choice_playlist) {
                case 1:
                    createPlayList(playList);
                    backToPrevious();
                    break;

                case 2:
                    addPlayList(songList, playList, playlistDetails);
                    backToPrevious();
                    break;

                case 3:
                    playListDetails(playList, playlistDetails);
                    backToPrevious();
                    break;

                case 4:
                    singSong(playlistDetails, finishSing);
                    backToPrevious();
                    break;

                case 5:
                    //finish
                    finishSong(finishSing);
                    backToPrevious();
                    break;

                case 6:
                    check = true;
                    System.out.println("\n------Thank you------\n");
                    break;
                default:
                    System.out.println("Invalid input! Please enter only digit 1 to 7.");
                    break;
            }

        }
    }

    public static void playlistMenu() {
        System.out.println("\n=========================");
        System.out.println("|       Playlist        |");
        System.out.println("=========================");
        System.out.println("|1. Create Play List    |");
        System.out.println("|2. Add Song to Playlist|");
        System.out.println("|3. Show Playlist Detail|");
        System.out.println("|4. Sing A Song         |");
        System.out.println("|5. Finish Song         |");
        System.out.println("|6. End Session         |");
        System.out.println("=========================\n");

        System.out.print("Please enter your choice(1 - 6): ");
    }

    public static void playList() {
        System.out.println("\n*************************");
        System.out.println("|       Playlist        |");
        System.out.println("*************************");
    }

    public static void addPlayList(SortedListInterface<Song> s, ListInterface<Playlist> p, QueueInterface<PlayListDetails> pd) {
        //select song
        Scanner sc = new Scanner(System.in);

        viewPlayList(p);
        Song song = null;
        Playlist playlist = null;
        int pId;
        int sId;
        boolean found = false;

        if (!p.isEmpty()) {
            System.out.print("\nEnter the playlist id: ");
            pId = sc.nextInt();
            sc.nextLine();
            Iterator<Playlist> pt = p.getIterator();     //create playlist iterator
            while (pt.hasNext() && !found) {
                playlist = pt.next();
                if (playlist.getPlaylistId() == pId) {
                    found = true;

                }
            }
            if (!found) {
                System.out.println("\nThe playlist ID is not found!");
            } else {
                viewSongList(s);
                boolean end = false;
                while (!end) {
                    Iterator<Song> it = s.getIterator();        //create iterator

                    System.out.print("\nEnter the song id: ");
                    sId = sc.nextInt();
                    sc.nextLine();
                    found = false;
                    while (it.hasNext() && !found) {
                        song = it.next();
                        if (song.getSongId() == sId) {
                            found = true;
                            //add to details
                            pd.enqueue(new PlayListDetails(song, playlist));
                            System.out.println("The song is successfully added to the playlist.");
                        }
                    }
                    if (!found) {
                        System.out.println("The song ID is not found.");
                    } else {
                        char input;
                        boolean valid = false;
                        while (!valid) {
                            System.out.println("\nContine to add song?(Y/N): ");
                            input = sc.next().charAt(0);
                            if (input == 'Y' || input == 'y') {
                                valid = true;
                                end = false;
                            } else if (input == 'N' || input == 'n') {
                                valid = true;
                                end = true;
                            } else {
                                System.out.println("\nInvalid input! Please try again!");
                                valid = false;

                            }
                        }
                    }
                }
            }
        }

    }

    public static void viewSongList(SortedListInterface<Song> s) {
        System.out.printf("\n%-10s%-50s%-35s%-15s%-15s%-12s%-10s\n", "Song ID", "Song Title", "Artist", "Genre", "Language", "Duration", "Year");
        System.out.println("=============================================================================================================================================");
        System.out.println(s);
    }

    public static void createPlayList(ListInterface<Playlist> p) {
        Scanner sc = new Scanner(System.in);
        String name = " ";
        if (p.isEmpty()) {
            System.out.print("\nEnter the name for your playlist: ");
            name = sc.nextLine();
            p.add(new Playlist(name));
            System.out.println("Playlist is created successfully!");
        } else {
            System.out.println("\nYou cannot create two playlist.");
        }

    }

    public static void viewPlayList(ListInterface<Playlist> p) {
        if (p.isEmpty()) {
            System.out.println("\nYou have not create any playlist yet!");
            System.out.println("\nPlease create a playlist!");
        } else {
            System.out.printf("\n%-15s%-20s", "Playlist ID", "Playlist Name");
            System.out.println("\n*********************************************");
            System.out.println(p);
        }
    }

    public static void playListDetails(ListInterface<Playlist> p, QueueInterface<PlayListDetails> pd) {
        if (pd.isEmpty()) {
            System.out.println("\nYou have not add any song to playlist!");
        } else {
            PlayListDetails details = null;
            Playlist playlist = null;
            boolean found = false;
            Scanner sc = new Scanner(System.in);
            int pId;
            viewPlayList(p);
            System.out.print("\nEnter the playlist id: ");
            pId = sc.nextInt();
            sc.nextLine();
            Iterator<Playlist> pl = p.getIterator();     //create playlist iterator
            while (pl.hasNext() && !found) {
                playlist = pl.next();
                if (playlist.getPlaylistId() == pId) {
                    found = true;

                }
            }
            if (!found) {
                System.out.println("\nThe playlist id is not found.");
            } else {
                Iterator<PlayListDetails> it = pd.getIterator();
                found = false;
                String song = "";
                while (it.hasNext()) {
                    details = it.next();
                    if (details.getPlaylist().getPlaylistId() == pId) {
                        //details.getPlaylist();
                        found = true;
                        song += "\n" + details.getSong();
                    }
                }
                if (found) {
                    System.out.print("\n");
                    //System.out.printf("%-20s%-35s", "Playlist ID", "Playlist Name");
                    //System.out.printf("\n%-20d%-35s", details.getPlaylist().getPlaylistId(), details.getPlaylist().getName());
                    System.out.println("Playlist ID: " + details.getPlaylist().getPlaylistId());
                    System.out.println("Playlist Name: " + details.getPlaylist().getName());
                    System.out.println("\nBelow is the song in the playlist: ");
                    System.out.printf("\n%-10s%-50s%-35s%-15s%-15s%-12s%-10s\n", "Song ID", "Song Title", "Artist", "Genre", "Language", "Duration", "Year");
                    System.out.print("=============================================================================================================================================");
                    System.out.print(song);
                    System.out.print("\n");
                } else {
                    System.out.println("\nNot Found!");
                }

            }

        }
    }

    public static void singSong(QueueInterface<PlayListDetails> pd, ListInterface<PlayListDetails> fs) {
        if (!pd.isEmpty()) {
            PlayListDetails song = pd.dequeue();
            fs.add(song);
            System.out.println("\nCurrent playing song is ");
            System.out.println("\nSong title: " + song.getSong().getSongTitle());
            System.out.println("Artist    : " + song.getSong().getArtist());
            System.out.println("Genre     : " + song.getSong().getGenre());
            System.out.println("Language  : " + song.getSong().getLanguage());
            System.out.println("Duration  : " + song.getSong().getDuration());
            System.out.println("Year      : " + song.getSong().getYear());

            if (!pd.isEmpty()) {
                //show next song
                song = pd.getFront();
                System.out.println("\nNext playing song is --> " + song.getSong().getSongTitle());
            } else {
                System.out.println("\nThis is the last song in the playlist.");
            }
        } else {
            System.out.println("\nThe playlist is empty.");
        }
    }

    public static void finishSong(ListInterface<PlayListDetails> fs) {
        PlayListDetails playListDetails = null;

        Iterator<PlayListDetails> pl = fs.getIterator();
        if (!fs.isEmpty()) {
            System.out.println("\nHistory of Song");
            System.out.println("===============");
            System.out.printf("\n%-15s%-20s%-3s%-10s%-50s%-35s%-15s%-15s%-12s%-10s\n", "Playlist ID", "Playlist Name", " | ", "Song ID", "Song Title", "Artist", "Genre", "Language", "Duration", "Year");
            System.out.print("=========================================================================================================================================================================================\n");
            while (pl.hasNext()) {
                playListDetails = pl.next();
                System.out.println(playListDetails);
            }
        } else {
            System.out.println("No record.");
        }

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

}
