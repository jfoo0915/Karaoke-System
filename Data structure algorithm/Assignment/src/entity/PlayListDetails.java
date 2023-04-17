/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ko Yun Xuan
 */
public class PlayListDetails {

    Song song;
    Playlist playlist;

    public PlayListDetails() {

    }

    public PlayListDetails(Song song, Playlist playlist) {
        this.playlist = playlist;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return playlist.toString() + " | " + song.toString();
    }

}
