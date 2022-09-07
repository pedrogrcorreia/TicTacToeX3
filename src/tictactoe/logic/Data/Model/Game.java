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
//    private Board selectedBoard;
//    private Board nextBoard;

    private Player activePlayer;
    private Player nextPlayer;

    private int gameMode;

    public void createNewGame(int gameMode){
        this.gameMode = gameMode;
    }

    public boolean play(int place){
        return board.play(place, activePlayer);
    }

    public boolean checkWin(int place){
        return board.checkWin(place, activePlayer);
    }

    public boolean checkFull(){
        return board.checkFull();
    }

    public boolean playPC(){
//        Random r = new Random();
//        int place = r.nextInt(9+1);
//        selectedBoard = nextBoard;
//        selectedBoard.play(place, activePlayer);
//        nextBoard = board.getBoard(place);
//        return selectedBoard.checkWin(place, activePlayer);
        return true;
    }

    public void nextPlayer(){
        Player p = activePlayer;
        activePlayer = nextPlayer;
        nextPlayer = p;
    }

    public void nextBoard(int place){
        board.setSelectedBoardNumber(place);
        board.setSelectedBoard();
    }

    public void printBoards(){
        System.out.println(board.printBigBoard());
    }

    public int getGameMode(){
        return gameMode;
    }

    public Board getSelectedBoard(){
        return board.getSelectedBoard();
    }

    public int getSelectedBoardNumber(){
        return board.getSelectedBoardNumber();
    }

    public Player getWinner(){
        return activePlayer;
    }

    public Board getBoard(int row, int col){ return board.getBoard(row, col); }
}
