package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;
//import tictactoe.StateAdapter;

public class PlayerTurn extends StateAdapter {
    public PlayerTurn(Game game) {
        super(game);
    }

    @Override
    public tictactoe.logic.States.IState playerTurn(int place, int playBoard) {
        if(getGame().play(place, playBoard)) {

//        if(getGame().play(place)) {
//        getGame().checkWinOnBoard(place);
//        getGame().checkWinGame(place);
            getGame().nextPlayer();
            getGame().setSelectedBoard();
            return new PlayerTurn(getGame());
        }else{
            return new PlayerTurn(getGame());
        }
//        }else{
//            getGame().getWinner();
//            return new EndGame(getGame());
//        }
//        if(getGame().getGameMode() == 0){
//            return new PlayerTurn(getGame());
//        } else{
//            return new PCTurn(getGame());
//        }
    }

    @Override
    public State getCurrentState() {
        return State.PLAYER_TURN;
    }
}
