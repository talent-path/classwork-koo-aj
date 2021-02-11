package com.tp.PraiseDatabase.Controller;



import com.tp.PraiseDatabase.Models.Song;
import com.tp.PraiseDatabase.Services.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praisedatabase")
public class PraiseController {
    @Autowired
    PraiseService service;

    @PostMapping("/define")
    public ResponseEntity addSong(@RequestBody Song s) {
        Song song = service.addSong(s.getTitle(), s.getArtists(), s.getTimeSig(), s.getTempo(), s.getPdfUrl());
        return ResponseEntity.ok(song);
    }

    @DeleteMapping("/delete/{songID}")
    public Song deleteSong(@PathVariable Integer songID) {
        return service.deleteSong(songID);
    }
}
