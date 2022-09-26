package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

import java.io.Serializable;

public class PCTurn extends tictactoe.logic.States.StateAdapter implements Serializable {
    public PCTurn(Game game) {
        super(game);
    }

    @Override
    public IState pcTurn() {
        if(getGame().playPC()){
            getGame().checkWinOnBoard(getGame().getRandomPlace());
            if(getGame().checkWin()){
                return endGame();
            }
            getGame().setSelectedBoard();
            getGame().nextPlayer();
            return new PlayerTurn(getGame());
        }
        return new PCTurn(getGame());
    }

    @Override
    public State getCurrentState() {
        return State.PC_TURN;
    }
}
