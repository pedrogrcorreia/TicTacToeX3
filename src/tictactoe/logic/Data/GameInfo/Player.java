package tictactoe.logic.Data.GameInfo;

public enum Player {
    PLAYER_X("X"),
    PLAYER_O("O"),
    TIE("T");

    private final String piece;

    Player(String piece){this.piece = piece;}

    @Override
    public String toString() {
        return piece;
    }
}
