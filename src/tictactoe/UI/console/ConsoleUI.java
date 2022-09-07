package tictactoe.UI.console;

import tictactoe.logic.GameClient;
import tictactoe.logic.State;

import java.util.Scanner;

public class ConsoleUI {
    GameClient gameClient;
    private boolean quit = false;
    private Scanner sc = new Scanner(System.in);

    public ConsoleUI(GameClient gameClient){
        this.gameClient = gameClient;
    }
    public void run(){
        while(!quit){
//            System.out.println("Start new game (N).");
//            String s;
//            s = sc.next();
            game();
        }
    }

    public void createNewGame(){
        System.out.println("Select an option:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.print("Option: ");
        int gameMode = 0;
        String s;
        if(sc.hasNextInt()){
            gameMode = sc.nextInt();
            if(gameMode < 0 || gameMode > 1){
                createNewGame();
            }
            gameClient.createNewGame(gameMode);
            return;
        }
    }

    public void playerTurn(){
//        gameClient.getSelectedBoard();
        System.out.println("Board number: " + gameClient.getSelectedBoardNumber() + "\n");
        System.out.println("Board: " + gameClient.getSelectedBoard().printBoard() + "\n");
        System.out.println("Play: ");
        int place = 0;
        if(sc.hasNextInt()){
            place = sc.nextInt();
            if(place < 0 || place > 8){
                playerTurn();
            }
            gameClient.playerTurn(place);
        }
    }

    public void pcTurn(){

    }

    public void game(){
        State state = gameClient.getCurrentState();
        switch(state){
            case NEW_GAME:
                createNewGame();
                break;
            case PLAYER_TURN:
                playerTurn();
                break;
            case PC_TURN:
                pcTurn();
                break;
        }
    }
}
