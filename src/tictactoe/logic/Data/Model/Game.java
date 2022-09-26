package tictactoe.logic.Data.Model;

import tictactoe.logic.Data.GameInfo.BigBoard;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.Data.GameInfo.Player;

public class Game {

    public Game(){
        board = new BigBoard();
        activePlayer = Player.PLAYER_X;
        nextPlayer = Player.PLAYER_O;
    }

    private BigBoard board;

    private Player activePlayer;
    private Player nextPlayer;

    private int gameMode;

    public void createNewGame(int gameMode){
        this.gameMode = gameMode;
    }

    public boolean play(int place, int playBoard){
        return board.play(place, activePlayer, playBoard);
    }

    public boolean checkWinOnBoard(int place){
        return board.checkWinOnBoard(place, activePlayer);
    }

    public boolean checkWin(){
        return board.checkWin(activePlayer);
    }

    public boolean checkFull(){
        return board.checkFull();
    }

    public boolean playPC(){
        return true;
    }

    public void nextPlayer(){
        Player p = activePlayer;
        activePlayer = nextPlayer;
        nextPlayer = p;
    }

    public void printBoards(){
        System.out.println(board.printBigBoard());
    }

    public int getGameMode(){
        return gameMode;
    }

    public Player getWinner(){
        return board.getWinner();
    }

    public Board getBoard(int row, int col){ return board.getBoard(row, col); }

    public void setSelectedBoard(){
        board.setSelectedBoard();
    }

    public void resetGame(){
        board = new BigBoard();
        activePlayer = Player.PLAYER_X;
        nextPlayer = Player.PLAYER_O;
    }
}
