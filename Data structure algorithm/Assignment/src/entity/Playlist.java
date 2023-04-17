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
public class Playlist implements Comparable<Playlist> {

    private int pId = 1000;
    private String name;
    private static int playlistCount = 0;

    public Playlist() {
        playlistCount++;
    }

    public Playlist(String name) {
        this.pId = pId + playlistCount;
        this.name = name;
        playlistCount++;
    }

    public int getPlaylistId() {
        return pId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getPlaylistCount() {
        return playlistCount;
    }

    @Override
    public int compareTo(Playlist p) {
        return this.name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return String.format("%-15d%-20s", pId, name);
    }

}
