package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullGuessException;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.services.ConnectFourService;
import com.tp.connectfour.services.Rng;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConnectFourServiceTests {

    @Autowired
    ConnectFourService service;

    @BeforeEach
    public void setup() throws InvalidGameIdException {

        List<ConnectFourViewModel> allGames = service.getAllGames();

        for( ConnectFourViewModel toDelete : allGames ){
            service.deleteGame( toDelete.getGameId() );
        }
    }

    @Test
    public void startGameTestGoldenPath(){

        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);

        //2. Act
        ConnectFourViewModel game =  service.startGame();
        assertEquals( 1, game.getGameId());

        assertEquals('X', game.getCurrentPlayer());
        char[][] board = new char[6][7];
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = '_';
            }
        }
        assertArrayEquals(board, game.getGameBoard());

        //3. Assert

    }

    @Test
    public void deleteGameTestGoldenPath() {
        ConnectFourViewModel game = service.startGame();
        Integer id = game.getGameId();
        try {
            service.deleteGame(id);
            assertEquals(null, game.getGameId());
        } catch (InvalidGameIdException e) {
            fail();
        }
    }

    @Test
    public void deleteGameTestNull() {
        ConnectFourViewModel game = service.startGame();
        Integer id = game.getGameId();
        try {
            service.deleteGame(null);
            fail();
        } catch (InvalidGameIdException e) {
            fail();
        }

    }

    @Test
    public void getAllGameTest() {
        service.startGame();
        service.startGame();
        service.startGame();
        for (int i = 0; i < service.getAllGames().size(); i++) {
            assertEquals(i + 1, service.getGameById(i).getGameId());
        }
    }

    @Test
    public void getGameByIdTest() {

    }

}
