package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

import java.io.Serializable;

public class EndGame extends StateAdapter implements Serializable {
    public EndGame(Game game) {
        super(game);
    }

    @Override
    public IState endGame() {
        getGame().resetGame();
        return new NewGame(getGame());
    }

    @Override
    public IState createNewGame(int gameMode) {
        getGame().resetGame();
        return new PlayerTurn(getGame());
    }

    @Override
    public State getCurrentState() {
        return State.END_GAME;
    }
}
