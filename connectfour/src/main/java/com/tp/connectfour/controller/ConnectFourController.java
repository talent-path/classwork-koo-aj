package com.tp.connectfour.controller;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.services.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectFourController {

    @Autowired
    ConnectFourService service;

    @GetMapping( "/game/{gameId}" )
    public ConnectFourViewModel getGameById(@PathVariable Integer gameId){
        return service.getGameById(gameId);
    }

    @PostMapping("/begin")
    public ConnectFourViewModel startGame() {
        ConnectFourViewModel game = service.startGame();
        return game;
    }

    @DeleteMapping("/delete/{gameId}")
    public String deleteGame( @PathVariable Integer gameId ){
        try {
            service.deleteGame( gameId );
            return "Game " + gameId + " successfully deleted.";
        } catch (InvalidGameIdException e) {
            return e.getMessage();
        }

    }

//    @PostMapping("/makeMove")
//    public ResponseEntity makeMove(@RequestBody MakeMoveRequest request) {
//        ConnectFourViewModel toReturn = null;
//        try {
//            toReturn = service
//        } catch (NullPointerException e) {
//            e.getStackTrace();
//        }
//    }
}
