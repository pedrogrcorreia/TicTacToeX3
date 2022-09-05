package Data.GameInfo;

public class Board {

    private final int NUM_COL = 3;
    private final int NUM_LIN = 3;

    private Player winner;

    public Board(){
        board = new String[NUM_LIN][NUM_COL];
        for(int i = 0; i<NUM_LIN; i++){
            for(int j = 0; j<NUM_COL; j++){
                board[i][j] = "*";
            }
        }
    }

    private String[][] board;

    public String printBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<NUM_LIN; i++){
            for(int j = 0; j<NUM_COL; j++) {
                sb.append(this.board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void play(int place, Player player){
        int row = place / NUM_COL;
        int col = place % NUM_COL;
        this.board[row][col] = player.toString();
    }

    public boolean checkRow(int place, Player player){
        int row = place / NUM_COL;
        for(int i = 0; i < NUM_COL; i++){
            if(board[row][i] != player.toString()){
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int place, Player player){
        int col = place % NUM_COL;
        for(int i = 0; i < NUM_LIN; i++){
            if(board[i][col] != player.toString()){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(Player player){
        for(int i = 0; i<NUM_LIN; i++){
            for(int j = 0; j<NUM_COL; j++){
                if(i == j){
                    if(board[i][j] != player.toString()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkSecDiagonal(Player player){
        for(int i = 0; i<NUM_LIN; i++){
            for(int j = 0; j<NUM_COL; j++){
                if ((i + j) == (NUM_COL - 1)){
                    if(board[i][j] != player.toString()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkWin(int place, Player player){
        if(checkRow(place, player)){
            return true;
        }
        if(checkCol(place, player)){
            return true;
        }
        if(checkDiagonal(player)){
            return true;
        }
        return checkSecDiagonal(player);
    }
}
