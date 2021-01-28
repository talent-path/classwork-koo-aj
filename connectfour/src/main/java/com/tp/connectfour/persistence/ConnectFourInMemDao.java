package com.tp.connectfour.persistence;

import com.tp.connectfour.models.ConnectFourGame;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFourInMemDao implements ConnectFourDao{

    private List<ConnectFourGame> allGames = new ArrayList<>();
    public ConnectFourInMemDao(){
//        ConnectFourGame game = new ConnectFourGame(100, 'X');
//        allGames.add(game);
    }
    @Override
    public int startGame(Character player) {

        int id = 0;
        for(ConnectFourGame toCheck: allGames){
            if(toCheck.getGameId() > id){
                id = toCheck.getGameId();
            }
        }
        id++;
        ConnectFourGame toAdd = new ConnectFourGame(id, player);
        allGames.add(toAdd);

        return id;
    }

    @Override
    public ConnectFourGame getGameById(Integer gameId) {
        ConnectFourGame toReturn = null;
        for (ConnectFourGame toCheck : allGames) {
            if (toCheck.getGameId().equals(gameId)) {
                toReturn = new ConnectFourGame(toCheck);
                break;
            }
        }
        return toReturn;
    }
}
