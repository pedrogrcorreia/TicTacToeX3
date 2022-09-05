package Data.GameInfo;

public enum Player {
    PLAYER_X("X"),
    PLAYER_O("O");

    private final String piece;

    Player(String piece){this.piece = piece;}

    @Override
    public String toString() {
        return piece;
    }
}
