package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.State;

public class EndGame extends StateAdapter {
    public EndGame(Game game) {
        super(game);
    }

    @Override
    public State getCurrentState() {
        return State.END_GAME;
    }
}
