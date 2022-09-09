package tictactoe.logic.States;

import tictactoe.logic.Data.Model.Game;

public abstract class StateAdapter implements IState {
    private final Game game;

    public StateAdapter(Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }

    @Override
    public IState createNewGame(int gameMode) {
        return this;
    }

    @Override
    public IState playerTurn(int place, int playBoard) {
        return this;
    }

    @Override
    public IState pcTurn() {
        return this;
    }

    @Override
    public IState endGame() {
        return this;
    }
}
