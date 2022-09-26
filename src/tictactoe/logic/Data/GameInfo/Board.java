package tictactoe.logic.Data.GameInfo;

import java.io.Serializable;

public class Board implements Serializable {

    private final int NUM_COL = 3;
    private final int NUM_ROW = 3;

    private Player winner;
    private boolean active;
    private boolean full;

    public Board(){
        board = new String[NUM_ROW][NUM_COL];
        active = true;
        full = false;
        winner = null;
        for(int i = 0; i< NUM_ROW; i++){
            for(int j = 0; j<NUM_COL; j++){
                board[i][j] = " ";
            }
        }
    }

    private String[][] board;

    public String printBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< NUM_ROW; i++){
            for(int j = 0; j<NUM_COL; j++) {
                sb.append(this.board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean play(int place, Player player){
        int row = place / NUM_COL;
        int col = place % NUM_COL;
        if(this.board[row][col] == " "){
            this.board[row][col] = player.toString();
            return true;
        }
        System.out.println("You can't make this move.");
        return false;
    }

    public boolean checkRow(int place, Player player){
        int row = place / NUM_COL;
        for(int i = 0; i < NUM_COL; i++){
            if(board[row][i] != player.toString()){
                return false;
            }
        }
        winner = player;
        return true;
    }

    public boolean checkCol(int place, Player player){
        int col = place % NUM_COL;
        for(int i = 0; i < NUM_ROW; i++){
            if(board[i][col] != player.toString()){
                return false;
            }
        }
        winner = player;
        return true;
    }

    public boolean checkDiagonal(Player player){
        for(int i = 0; i< NUM_ROW; i++){
            for(int j = 0; j<NUM_COL; j++){
                if(i == j){
                    if(board[i][j] != player.toString()){
                        return false;
                    }
                }
            }
        }
        winner = player;
        return true;
    }

    public boolean checkSecDiagonal(Player player){
        for(int i = 0; i< NUM_ROW; i++){
            for(int j = 0; j<NUM_COL; j++){
                if ((i + j) == (NUM_COL - 1)){
                    if(board[i][j] != player.toString()){
                        return false;
                    }
                }
            }
        }
        winner = player;
        return true;
    }

    public boolean checkWin(int place, Player player){
        if(checkRow(place, player)){
            System.out.println("Player " + player + " won!");
            winner = player;
            return true;
        }
        if(checkCol(place, player)){
            System.out.println("Player " + player + " won!");
            winner = player;
            return true;
        }
        if(checkDiagonal(player)) {
            System.out.println("Player " + player + " won!");
            winner = player;
            return true;
        }
        if(checkSecDiagonal(player)){
            System.out.println("Player " + player + " won!");
            winner = player;
            return true;
        }
        return false;
    }

    public boolean checkFull(){
        for(int i = 0; i< NUM_ROW; i++){
            for(int j = 0; j<NUM_COL; j++){
                if(board[i][j] == " "){
                    return false;
                }
            }
        }
//        winner = Player.TIE;
        full = true;
        return true;
    }

    public boolean getActive(){
        return active;
    }

    public boolean isWon(){
        if(winner == null){
            return false;
        }
        return true;
    }

    public Player getWinner(){
        return winner;
    }

    public void setActive(boolean state){
        active = state;
    }

    public boolean getFull(){
        return full;
    }

    public String[][] getStringBoard(){
        return board;
    }
}
