package tictactoe.logic.States;

import tictactoe.logic.State;

public interface IState {

    IState createNewGame(int gameMode);
    IState playerTurn(int place, int playBoard);
    IState pcTurn();

    IState endGame();

    State getCurrentState();
}
