package Data.Model;

import Data.GameInfo.BigBoard;
import Data.GameInfo.Board;
import Data.GameInfo.Player;

public class Game {

    public Game(){
        board = new BigBoard();
        selectedBoard = board.getBoard(4);
        nextBoard = selectedBoard;
        activePlayer = Player.PLAYER_X;
        nextPlayer = Player.PLAYER_O;
    }

    private BigBoard board;
    private Board selectedBoard;
    private Board nextBoard;

    private Player activePlayer;
    private Player nextPlayer;
    public boolean play(int place){
        selectedBoard = nextBoard;
        selectedBoard.play(place, activePlayer);
        nextBoard = board.getBoard(place);
        return selectedBoard.checkWin(place, activePlayer);
    }

    public void nextPlayer(){
        Player p = activePlayer;
        activePlayer = nextPlayer;
        nextPlayer = p;
    }

    public void printBoards(){
        System.out.println(board.printBigBoard());
    }
}
