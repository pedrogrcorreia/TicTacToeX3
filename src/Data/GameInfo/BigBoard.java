package Data.GameInfo;

import java.util.ArrayList;

public class BigBoard {

    public BigBoard(){
        boards = new ArrayList<Board>(9);
        for(int i = 0; i < 9; i++){
            boards.add(new Board());
        }
    }

    private ArrayList<Board> boards;

    public Board getBoard(int nboard){
        return boards.get(nboard);
    }

    public String printBigBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append("Board number " + (i + 1) + "\n");
            sb.append(boards.get(i).printBoard());
            sb.append("\n");
        }
        return sb.toString();
    }
}
