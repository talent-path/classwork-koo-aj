package com.tp.PraiseDatabase.Models;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private Integer songID;
    private String title;
    private List<String> artists;
    private String timeSig;
    private String tempo;
    private String pdfUrl;
    private String key;

    public Song() {
        //default constructor
    }
    public Song(Integer songID, String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) {
        this.songID = songID;
        this.title = title;
        this.artists = artists;
        this.timeSig = timeSig;
        this.key = key;
        this.tempo = tempo;
        this.pdfUrl = pdfUrl;
    }
    public Song(Song that) {
        this.songID = that.songID;
        this.title = that.title;
        List<String> list = new ArrayList<>();
        list.addAll(that.artists);
        this.key = that.key;
        this.timeSig = that.timeSig;
        this.tempo = that.tempo;
        this.pdfUrl = that.pdfUrl;
    }

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public String getTimeSig() {
        return timeSig;
    }

    public void setTimeSig(String timeSig) {
        this.timeSig = timeSig;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
