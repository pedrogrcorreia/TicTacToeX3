package tictactoe.logic.Data.GameInfo;

public class BigBoard {

    public final int NUM_COL = 3;
    public final int NUM_ROW = 3;
    private final int FIRST_BOARD = 4;

    private Board[][] boards;

    private Board selectedBoard;
    private int selectedBoardNumber;

    public BigBoard(){
        boards = new Board[NUM_ROW][NUM_COL];
        for(int i = 0; i < NUM_ROW; i++){
            for(int j = 0; j < NUM_COL; j++) {
                boards[i][j] = new Board();
            }
        }

        int row = getRow(FIRST_BOARD);
        int col = getCol(FIRST_BOARD);
        selectedBoard = boards[row][col];
        selectedBoardNumber = FIRST_BOARD;
    }

    private int getRow(int place){
        return place / NUM_COL;
    }

    private int getCol(int place){
        return place % NUM_COL;
    }

    public boolean play(int place, Player player){
        return selectedBoard.play(place, player);
    }

    public boolean checkWin(int place, Player player){
        return selectedBoard.checkWin(place, player);
    }

    public boolean checkFull(){
        return selectedBoard.checkFull();
    }

    public Board getBoard(int nboard){
        int row = getRow(nboard);
        int col = getCol(nboard);
        return boards[row][col];
    }

    public Board getSelectedBoard(){
        return selectedBoard;
    }

    public void setSelectedBoard(){
        int row = getRow(selectedBoardNumber);
        int col = getCol(selectedBoardNumber);
        this.selectedBoard = boards[row][col];
    }

    public int getSelectedBoardNumber(){
        return selectedBoardNumber;
    }

    public void setSelectedBoardNumber(int place){
        this.selectedBoardNumber = place;
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
}
