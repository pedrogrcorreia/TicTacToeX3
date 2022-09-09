package tictactoe.logic;

import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.Data.Model.Game;
import tictactoe.logic.States.IState;
import tictactoe.logic.States.NewGame;

public class GameClient {
    private Game game;
    private IState state;

    public GameClient(){
        game = new Game();
        state = new NewGame(game);
    }

    private void setState(IState state){this.state = state;}

    public void createNewGame(int gameMode){
        setState(state.createNewGame(gameMode));
    }

    public void playerTurn(int place, int playBoard){
        setState(state.playerTurn(place, playBoard));
    }

    public void pcTurn(){
        setState(state.pcTurn());
    }

    public void printBoards(){
        game.printBoards();
    }

    public State getCurrentState(){
        return state.getCurrentState();
    }

    public Board getBoard(int row, int col){ return game.getBoard(row, col); }
}
