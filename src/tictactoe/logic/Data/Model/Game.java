package tictactoe.logic.Data.Model;

import tictactoe.logic.Data.GameInfo.BigBoard;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.Data.GameInfo.Player;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {

    public Game(){
        board = new BigBoard();
        activePlayer = Player.PLAYER_X;
        nextPlayer = Player.PLAYER_O;
    }

    private BigBoard board;

    private Player activePlayer;
    private Player nextPlayer;

    private int randomPlace;
    private int randomBoard;

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
        Random r = new Random();
        randomPlace = r.nextInt(9);
        randomBoard = r.nextInt(9);
        return board.play(randomPlace, activePlayer, randomBoard);
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

    public int getRandomPlace(){
        return randomPlace;
    }

    public void setSelectedBoard(){
        board.setSelectedBoard();
    }

    public void resetGame(){
        board = new BigBoard();
        activePlayer = Player.PLAYER_X;
        nextPlayer = Player.PLAYER_O;
    }
}
