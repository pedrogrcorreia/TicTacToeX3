package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

public class PlayerTurn extends StateAdapter {
    public PlayerTurn(Game game) {
        super(game);
    }

    @Override
    public IState playerTurn(int place, int playBoard) {
        if(getGame().play(place, playBoard)) {
            getGame().checkWinOnBoard(place);
            if(getGame().checkWin()){
                return new EndGame(getGame());
            }
            getGame().setSelectedBoard();
            getGame().nextPlayer();
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
