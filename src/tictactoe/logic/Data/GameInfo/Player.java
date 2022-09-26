package tictactoe.logic.Data.GameInfo;

import tictactoe.logic.Util.Save;

import java.io.Serializable;

public enum Player implements Serializable {
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
