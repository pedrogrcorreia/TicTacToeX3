package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

import java.io.Serializable;

public class NewGame extends tictactoe.logic.States.StateAdapter implements Serializable {

    public NewGame(Game game) {
        super(game);
    }

    @Override
    public IState createNewGame(int gameMode) {
        getGame().createNewGame(gameMode);
        return new tictactoe.logic.States.PlayerTurn(getGame());
    }

    @Override
    public State getCurrentState() {
        return State.NEW_GAME;
    }
}
