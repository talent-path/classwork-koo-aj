package com.tp.PraiseDatabase.Controller;

import com.tp.PraiseDatabase.Exceptions.InvalidSongException;
import com.tp.PraiseDatabase.Models.Song;
import com.tp.PraiseDatabase.Services.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/praisedatabase")
public class PraiseController {
    @Autowired
    PraiseService service;

    @GetMapping("/allSongs")
    public List<Song> getAllSongs() {
        return service.getAllSongs();
    }

    // Get songs by Title
    @GetMapping("/songsByTitle")
    public List<Song> getSongsByTitle(@PathVariable String title) {
        return service.getSongsByTitle(title);
    }
    // Get songs by Artist
    @GetMapping("/songsByArtist")
    public List<Song> getSongsByArtist(@PathVariable String artist) {
        return  service.getSongsByArtist(artist);
    }

    @PostMapping("/addSong")
    public ResponseEntity addSong(@RequestBody Song s) throws InvalidSongException {
        Song song = service.addSong(s.getTitle(), s.getArtists(), s.getKey(), s.getTimeSig(), s.getTempo(), s.getPdfUrl());
        return ResponseEntity.ok(song);
    }

    @PutMapping("/updateSong")
    public ResponseEntity editSong(@RequestBody Song request) {
        Song song = null;
        try {
            song = service.editBook(request.getSongID(), request.getTitle(), request.getArtists(), request.getKey(), request.getTimeSig(), request.getTempo(), request.getPdfUrl());
        } catch (InvalidSongException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(song);
    }

    @DeleteMapping("/deleteSong/{songID}")
    public Song deleteSong(@PathVariable Integer songID) throws InvalidSongException {
        return service.deleteSong(songID);
    }
}
