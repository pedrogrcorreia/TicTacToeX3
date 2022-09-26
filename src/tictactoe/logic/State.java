package tictactoe.logic;

import java.io.Serializable;

public enum State implements Serializable {
    NEW_GAME,
    PLAYER_TURN,
    PC_TURN,
    END_GAME;
}
