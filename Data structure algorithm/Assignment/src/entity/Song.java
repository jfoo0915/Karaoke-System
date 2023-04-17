/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Lim Wen Jing
 */
public class Song implements Comparable<Song> {

    private int songId = 1000;
    private String songTitle;
    private String artist;
    private String genre;
    private String language;
    private String duration;
    private int year;
    private static int songCount = 0;

    public Song() {
        songCount++;
    }
    
    public Song(String songTitle, String artist, String genre, String language, String duration, int year) {
        this.songId = songId + songCount;
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.year = year;
        songCount++;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getSongCount() {
        return songCount;
    }

    @Override
    public int compareTo(Song s) {
        return this.songTitle.compareTo(s.songTitle);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        Song s = (Song) o;

        if (!s.songTitle.equals(this.songTitle)) {
            return false;
        }
        if (!s.artist.equals(this.artist)) {
            return false;
        }
        if (!s.genre.equals(this.genre)) {
            return false;
        }
        if (!s.language.equals(this.language)) {
            return false;
        }
        if (!s.duration.equals(this.duration)) {
            return false;
        }
        if (s.year != this.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return //String.format("\nSong ID%-10sSong Title%-10sArtist%-10sGenre%-10sLanguage%-10sDuration%-10sYear\n", "", "", "", "", "")+
                String.format("%-10d%-50s%-35s%-15s%-15s%-12s%-10d", songId, songTitle, artist, genre, language, duration, year);
    }

}
