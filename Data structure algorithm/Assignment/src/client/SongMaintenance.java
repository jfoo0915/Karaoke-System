/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Song;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Lim Wen Jing
 */
public class SongMaintenance {

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

    public void songMain(SortedListInterface<Song> songList) {
        Scanner sc = new Scanner(System.in);
        //Create and add songs to sorted list

        //song operation menu
        boolean end = false;
        //boolean valid = true;
        while (!end) {
            songMaintenance();
            int songOption = sc.nextInt();
            switch (songOption) {
                case 1:
                    viewSongList(songList);
                    backToPrevious();
                    break;

                case 2:
                    addSong(songList);
                    backToPrevious();
                    break;

                case 3:
                    removeSong(songList);
                    backToPrevious();
                    break;

                case 4:
                    updateSong(songList);
                    backToPrevious();
                    break;

                case 5:
                    searchSong(songList);
                    backToPrevious();
                    break;

                case 6:
                    generateSongReport(songList);
                    backToPrevious();
                    break;

                case 7:
                    end = true;
                    break;

                default:
                    System.out.println("Invalid input! Please enter only digit 1 to 7.");
                    break;
            }
        }
    }

    public void songMaintenance() {
        System.out.println("\n=================");
        System.out.println(" Song Maintenance ");
        System.out.println("=================");
        System.out.println("1. View Song Menu");
        System.out.println("2. Add New Song");
        System.out.println("3. Remove Song");
        System.out.println("4. Update Song");
        System.out.println("5. Search Song");
        System.out.println("6. Generate Song Report");
        System.out.println("7. Exit menu");

        System.out.print("\nChoose an option: ");
    }

    public void createSongList(SortedListInterface<Song> s) {
        //English (Pop)
        s.add(new Song("Red", "Taylor Swift", "Pop", "English", "3:43", 2021));
        s.add(new Song("Lover", "Taylor Swift", "Pop", "English", "3:41", 2019));
        s.add(new Song("Blank Space", "Taylor Swift", "Pop", "English", "3:52", 2014));
        s.add(new Song("Wildest Dreams", "Taylor Swift", "Pop", "English", "3:40", 2014));
        s.add(new Song("Last Christmas", "Taylor Swift", "Pop", "English", "3:28", 2007));

        s.add(new Song("Rolling In the Deep", "Adele", "Pop", "English", "3:48", 2011));
        s.add(new Song("Hello", "Adele", "Pop", "English", "4:56", 2015));

        //Soundtrack
        s.add(new Song("My Hear Will Go on", "Celine Dion", "Soundtrack", "English", "4:41", 1997));
        s.add(new Song("A Whole New World", "Peabo Bryson & Regina Belle", "SoundTrack", "English", "4:10", 1992));
        s.add(new Song("A Whole New World", "Mena Massoud & Naomi Scott", "SoundTrack", "English", "2:56", 2019));

        //Japanese 
        s.add(new Song("Lemon", "Kenshi Yonezu", "J-Pop", "Japanese", "4:16", 2020));
        s.add(new Song("Loser", "Kenshi Yonezu", "J-Pop", "Japanese", "4:04", 2017));
        s.add(new Song("Uchiagehanabi", "DAOKO x Kenshi Yonezu", "Anison", "Japanese", "4:50", 2017));
        s.add(new Song("Gurenge", "LiSA", "Anison", "Japanese", "3:59", 2020));
        s.add(new Song("Zenzenzense", "RADWIMPS", "Anison", "Japanese", "4:46", 2016));
        s.add(new Song("Nandemonaiya", "RADWIMPS", "Anison", "Japanese", "5:44", 2016));
        s.add(new Song("Dream Lantern", "RADWIMPS", "Anison", "Japanese", "2:12", 2016));
        s.add(new Song("Grand Escape", "RADWIMPS", "Anison", "Japanese", "5:39", 2019));
        s.add(new Song("Is There Still Anything That Love Can Do?", "RADWIMPS", "Anison", "Japanese", "6:54", 2019));

        //Mandarin
        s.add(new Song("Rice Field", "Jay Chou", "C-Pop", "Mandarin", "3:43", 2008));
        s.add(new Song("Common Jasmine Orange", "Jay Chou", "C-Pop", "Mandarin", "5:01", 2004));
        s.add(new Song("Nocturne", "Jay Chou", "C-Pop", "Mandarin", "4:34", 2005));
        s.add(new Song("Romantic Cellphone", "Jay Chou", "C-Pop", "Mandarin", "3:57", 2008));
        s.add(new Song("Chapter Seven", "Jay Chou", "C-Pop", "Mandarin", "3:46", 2006));
        s.add(new Song("The Promised Love", "Jay Chou", "C-Pop", "Mandarin", "4:14", 2008));

        s.add(new Song("Super Star", "S.H.E", "C-Pop", "Mandarin", "3:17", 2003));
        s.add(new Song("Seventeen", "S.H.E", "C-Pop", "Mandarin", "5:09", 2018));
        s.add(new Song("Not Yet Lovers", "S.H.E", "C-Pop", "Mandarin", "4:37", 2001));

        //Malay Song
        s.add(new Song("Rasa Sayang", "Hanie Soraya", "Folk", "Malay", "3: 21", 2014));
        s.add(new Song("Arena Cahaya", "Zee Awi", "Soundtrack", "Malay", "4:16", 2015));
    }

    public void viewSongList(SortedListInterface<Song> s) {
        System.out.printf("\n%-10s%-50s%-35s%-15s%-15s%-12s%-10s\n", "Song ID", "Song Title", "Artist", "Genre", "Language", "Duration", "Year");
        System.out.println("=============================================================================================================================================");
        System.out.println(s);
    }

    public void removeSong(SortedListInterface<Song> s) {
        boolean found = false;
        boolean removed = false;
        Scanner sc = new Scanner(System.in);
        Song song = null;
        viewSongList(s);
        while (!found) {
            //create iterator
            Iterator<Song> it = s.getIterator();
            System.out.print("\nEnter the song id that you want to remove: ");
            int input = sc.nextInt();
            while (it.hasNext() && !found) {
                song = it.next();
                if (song.getSongId() == input) {
                    found = true;
                    System.out.println("\nThe following song will be removed from the song list: ");
                    removed = s.remove(song);

                    System.out.println(song);
                    if (removed) {
                        System.out.println("\nThe song is successfully removed from the list!");
                    } else {
                        System.out.println("\nThe song is failed to removed from the list!");
                    }
                }
            }
            if (!found) {
                System.out.println("The song id that you entered is not found. Please try again.");
            }
        }//end of while loop for validation of song id
    }

    public void addSong(SortedListInterface<Song> s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n==========");
        System.out.println(" Add Song ");
        System.out.println("==========");
        boolean stop = false;
        String title = "";
        String artist = "";
        String genre = "";
        String language = "";
        String duration = "";
        int year = 0;
  
        System.out.print("\nSong title: ");
        title = sc.nextLine();
        System.out.print("Artist: ");
        artist = sc.nextLine();
        System.out.print("Genre: ");
        genre = sc.nextLine();
        System.out.print("Language: ");
        language = sc.nextLine();
        System.out.print("Duration: ");
        duration = sc.nextLine();
        System.out.print("Year: ");
        year = sc.nextInt();

        boolean success = s.add(new Song(title, artist, genre, language, duration, year));
        if (success) {
            System.out.println("\nSong is added successfully!");
        } else {
            System.out.println("\nFailed to add the song. Please make sure that you are not adding the song that is already exist.");

        }

    }

    public void updateSong(SortedListInterface<Song> s) {
        boolean valid = false;
        boolean found = false;
        int option = 0;
        String title = "";
        String artist = "";
        String genre = "";
        String language = "";
        String duration = "";
        int year = 0;

        Scanner sc = new Scanner(System.in);
        Song song = null;
        viewSongList(s);
        System.out.println("\n=============");
        System.out.println(" Update Song ");
        System.out.println("=============");
        while (!found) {
            //create iterator
            Iterator<Song> it = s.getIterator();
            System.out.print("\nEnter the song id of the song that you want to update: ");
            int input = sc.nextInt();
            sc.nextLine();

            while (it.hasNext() && !found) {
                song = it.next();
                if (song.getSongId() == input) {
                    found = true;
                    System.out.println("\n\tSong ID: " + song.getSongId());
                    System.out.println("\tSong title: " + song.getSongTitle());
                    System.out.println("\tArtist: " + song.getArtist());
                    System.out.println("\tGenre: " + song.getGenre());
                    System.out.println("\tLanguage: " + song.getLanguage());
                    System.out.println("\tDuration: " + song.getDuration());
                    System.out.println("\tYear: " + song.getYear());
                    System.out.println("\nWhat do you want to update?\n");
                    System.out.println(" 1. Song title");
                    System.out.println(" 2. Artist");
                    System.out.println(" 3. Genre");
                    System.out.println(" 4. Language");
                    System.out.println(" 5. Duration");
                    System.out.println(" 6. Year");
                    while (!valid) {
                        System.out.print("\nPlease enter an option (1-6): ");
                        option = sc.nextInt();
                        sc.nextLine();
                        switch (option) {
                            case 1:
                                System.out.print("New song title: ");
                                title = sc.nextLine();
                                song.setSongTitle(title);
                                valid = true;
                                break;

                            case 2:
                                System.out.print("\nNew artist: ");
                                artist = sc.nextLine();
                                song.setArtist(artist);
                                valid = true;
                                break;

                            case 3:
                                System.out.print("New genre: ");
                                genre = sc.nextLine();
                                song.setGenre(genre);
                                valid = true;
                                break;

                            case 4:
                                System.out.print("\nNew language: ");
                                language = sc.nextLine();
                                song.setLanguage(language);
                                valid = true;
                                break;

                            case 5:
                                System.out.print("\nNew duration: ");
                                duration = sc.nextLine();
                                song.setDuration(duration);
                                valid = true;
                                break;

                            case 6:
                                System.out.print("New year: ");
                                year = sc.nextInt();
                                song.setYear(year);
                                valid = true;
                                break;

                            default:
                                System.out.println("\nInvalid option! Please enter digit 1 to 6 only");
                                break;
                        }//end of switch
                    }//end of while loop for validating the option
                }//end of if(song.getSongId() == input){

            }//end of iterator loop
            if (!found) {
                System.out.println("The song id that you entered is not found. Please try again.");
            } else {
                System.out.println("Song is updated successfully!");
                System.out.println("\n\tSong ID: " + song.getSongId());
                System.out.println("\tSong title: " + song.getSongTitle());
                System.out.println("\tArtist: " + song.getArtist());
                System.out.println("\tGenre: " + song.getGenre());
                System.out.println("\tLanguage: " + song.getLanguage());
                System.out.println("\tDuration: " + song.getDuration());
                System.out.println("\tYear: " + song.getYear());
            }
        }//while loop for validity of song id
    }

    public void searchSong(SortedListInterface<Song> s) {
        boolean valid = false;
        boolean found = false;
        int option = 0;
        int id = 0;
        String title = "";
        String artist = "";
        String genre = "";
        String language = "";
        String duration = "";
        int year = 0;
        SortedListInterface<Song> result = new SortedArrayList<>();

        Scanner sc = new Scanner(System.in);
        Song song = null;
        System.out.println("\n=============");
        System.out.println(" Search Song ");
        System.out.println("=============");
        //while(!found){
        //create iterator
        Iterator<Song> it = s.getIterator();
        System.out.println("\nSearch using: \n");
        System.out.println(" 1. Song id");
        System.out.println(" 2. Song title");
        System.out.println(" 3. Artist");
        System.out.println(" 4. Genre");
        System.out.println(" 5. Language");
        System.out.println(" 6. Duration");
        System.out.println(" 7. Year");
        while (!valid) {
            System.out.print("\nPlease enter an option (1-7): ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.print("\nEnter the song id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getSongId() == id) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 2:
                    System.out.print("\nEnter the song title: ");
                    title = sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getSongTitle().equals(title)) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 3:
                    System.out.print("\nEnter the artist name: ");
                    artist = sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getArtist().equals(artist)) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 4:
                    System.out.print("Enter the genre of the song: ");
                    genre = sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getGenre().equals(genre)) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 5:
                    System.out.print("\nEnter the language of the song: ");
                    language = sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getLanguage().equals(language)) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 6:
                    System.out.print("\nEnter the duration of the song: ");
                    duration = sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getDuration().equals(duration)) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                case 7:
                    System.out.print("Enter the year of the song: ");
                    year = sc.nextInt();
                    sc.nextLine();
                    while (it.hasNext()) {
                        song = it.next();
                        if (song.getYear() == year) {
                            found = true;
                            result.add(song);
                        }
                    }
                    valid = true;
                    break;

                default:
                    System.out.println("\nInvalid option! Please enter digit 1 to 7 only");
                    break;
            }//end of switch
        }//end of while loop for validating the option

        if (!found) {
            System.out.println("\n0 results are found.");
        } else {
            System.out.println("\nWe have found " + result.getNumberOfEntries() + " results for you!");
            viewSongList(result);
        }
    }

    public void generateSongReport(SortedListInterface<Song> s) {

        SortedListInterface<Song> english = new SortedArrayList<>();
        SortedListInterface<Song> japanese = new SortedArrayList<>();
        SortedListInterface<Song> mandarin = new SortedArrayList<>();
        SortedListInterface<Song> other = new SortedArrayList<>();
        SortedListInterface<Song> newSong = new SortedArrayList<>();
        SortedListInterface<Song> oldSong = new SortedArrayList<>();
        SortedListInterface<Song> betweenSong = new SortedArrayList<>();

        Scanner sc = new Scanner(System.in);
        Song song = null;

        Iterator<Song> it = s.getIterator();

        while (it.hasNext()) {
            song = it.next();
            if (song.getLanguage().equals("English")) {
                english.add(song);
            } else if (song.getLanguage().equals("Japanese")) {
                japanese.add(song);
            } else if (song.getLanguage().equals("Mandarin")) {
                mandarin.add(song);
            } else {
                other.add(song);
            }

            if (song.getYear() < 2010) {
                oldSong.add(song);
            } else if (song.getYear() >= 2010 && song.getYear() <= 2020) {
                betweenSong.add(song);
            } else if (song.getYear() >= 2021) {
                newSong.add(song);
            }
        }
        
        
        
        
        
        
        
        
        
        System.out.println("\n=============");
        System.out.println(" Song Report ");
        System.out.println("=============");
        System.out.printf("\n%-40s: %2d", "Total number of songs", s.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of English songs", english.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of Japanese songs", japanese.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of Mandarin Songs", mandarin.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of other language songs", other.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of songs before 2010", oldSong.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d", "Total number of songs from 2010 to 2020", betweenSong.getNumberOfEntries());
        System.out.printf("\n%-40s: %2d\n", "Total number of songs from 2021 onwards", newSong.getNumberOfEntries()); 
    }

}
