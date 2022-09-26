package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

import java.io.Serializable;

public class PlayerTurn extends StateAdapter implements Serializable {
    public PlayerTurn(Game game) {
        super(game);
    }

    @Override
    public IState playerTurn(int place, int playBoard) {
        if(getGame().getGameMode() == 0) {
            if (getGame().play(place, playBoard)) {
                getGame().checkWinOnBoard(place);
                if (getGame().checkWin()) {
                    return new EndGame(getGame());
                }
                getGame().setSelectedBoard();
                getGame().nextPlayer();
                return new PlayerTurn(getGame());
            }
            return new PlayerTurn(getGame());
        } else{
            if(getGame().play(place, playBoard)){
                getGame().checkWinOnBoard(place);
                if (getGame().checkWin()) {
                    return new EndGame(getGame());
                }
                getGame().setSelectedBoard();
                getGame().nextPlayer();
                return new PCTurn(getGame());
            }
            return new PlayerTurn(getGame());
        }
    }

    @Override
    public State getCurrentState() {
        return State.PLAYER_TURN;
    }
}
