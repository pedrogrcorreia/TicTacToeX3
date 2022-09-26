package tictactoe.logic.Data.GameInfo;

public class BigBoard {

    public final int NUM_COL = 3;
    public final int NUM_ROW = 3;

    private Board[][] boards;
    private int lastPlayedBoard;
    private int lastRow;
    private int lastCol;
    private int lastPlayedPlace;
    private int rowPlayed;
    private int colPlayed;

    public BigBoard(){
        boards = new Board[NUM_ROW][NUM_COL];
        for(int i = 0; i < NUM_ROW; i++){
            for(int j = 0; j < NUM_COL; j++) {
                boards[i][j] = new Board();
                boards[i][j].setActive(true);
            }
        }
    }

    private int getRow(int place){
        return place / NUM_COL;
    }

    private int getCol(int place){
        return place % NUM_COL;
    }

    public boolean play(int place, Player player, int playBoard){
        lastPlayedBoard = playBoard;
        lastPlayedPlace = place;
        lastRow = getRow(lastPlayedBoard);
        lastCol = getCol(lastPlayedBoard);
        rowPlayed = getRow(lastPlayedPlace);
        colPlayed = getCol(lastPlayedPlace);
        System.out.println("Active player is: " + player.toString());
        return boards[lastRow][lastCol].play(place, player);
    }

    public boolean checkWinOnBoard(int place, Player player){
        return boards[lastRow][lastCol].checkWin(place, player);
    }

    public boolean checkFull(){
        return boards[lastRow][lastCol].checkFull();
    }

    public Board getBoard(int nboard){
        int row = getRow(nboard);
        int col = getCol(nboard);
        return boards[row][col];
    }

    public void setSelectedBoard(){
        for(int i = 0; i < NUM_ROW; i++){
            for(int j = 0; j < NUM_COL; j++){
                if(rowPlayed == i && colPlayed == j){
                    if(boards[rowPlayed][colPlayed].isWon() || boards[rowPlayed][colPlayed].checkFull()){
                        setPossibleBoards();
                        return;
                    }
                    System.out.println("Active board is: " + rowPlayed + " " + colPlayed);
                    boards[rowPlayed][colPlayed].setActive(true);
                    continue;
                }
                boards[i][j].setActive(false);
            }
        }
    }

    private void setPossibleBoards(){
        for(int i = 0; i < NUM_ROW; i++){
            for(int j = 0; j < NUM_COL; j++){
                if(!boards[i][j].isWon() && !boards[i][j].checkFull()){
                    boards[i][j].setActive(true);
                }
            }
        }
    }

    public String printBigBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUM_ROW; i++) {
            for(int j = 0; j < NUM_COL; j++) {
                sb.append("Board number " + i + " " + j + "\n");
                sb.append(boards[i][j].printBoard());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public Board getBoard(int row, int col){
        return boards[row][col];
    }

    public int[][] getActiveBoards(){
        int[][] active = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(boards[i][j].getActive() == true){
                    active[i][j] = 1;
                } else{
                    active[i][j] = 0;
                }
            }
        }
        return active;
    }
}
