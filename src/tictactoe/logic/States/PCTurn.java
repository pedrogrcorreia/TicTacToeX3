package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

public class PCTurn extends tictactoe.logic.States.StateAdapter {
    public PCTurn(Game game) {
        super(game);
    }

    @Override
    public IState pcTurn() {
        getGame().playPC();
//        getGame().checkWinOnBoard(place);
//        getGame().checkWinGame(place);
        getGame().nextPlayer();
        return new tictactoe.logic.States.PlayerTurn(getGame());
    }

    @Override
    public State getCurrentState() {
        return State.PC_TURN;
    }
}
