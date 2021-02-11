package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Models.Song;

import java.util.*;

public interface PraiseDao {
    Integer addSong(String title, List<String> artists, String timeSig, String tempo, String pdfUrl);
    Song deleteSong(Integer songID);
    Song getSongByID(Integer songID);
}
