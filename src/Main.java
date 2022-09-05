import Data.GameInfo.BigBoard;
import Data.GameInfo.Board;
import Data.GameInfo.Player;
import Data.Model.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        Board board = new Board();
//        board.printBoard();
//
//        BigBoard boards = new BigBoard();
//        System.out.println(boards.printBigBoard());
//
//        boards.getBoard(0).play(2, Player.PLAYER_X);
//        boards.getBoard(0).play(5, Player.PLAYER_X);
//        boards.getBoard(0).play(8, Player.PLAYER_X);
//        boards.getBoard(0).play(3, Player.PLAYER_O);
//        System.out.println(boards.printBigBoard());
//        System.out.println(boards.getBoard(0).checkWin(2, Player.PLAYER_X));

        Game game;
        game = new Game();
        Scanner sc = new Scanner(System.in);
        while(true){
            int place = sc.nextInt();
            game.play(place);
            game.nextPlayer();
            game.printBoards();
        }
//        game.play(3);
//        game.play(2);
//        game.printBoards();

    }
}
