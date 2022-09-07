package tictactoe.logic;

import tictactoe.logic.Data.GameInfo.Board;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameObservable {
    private GameClient gameClient;

    private final PropertyChangeSupport propertyChangeSupport;

    public GameObservable(GameClient gameClient){
        this.gameClient = gameClient;
        propertyChangeSupport = new PropertyChangeSupport(gameClient);
        propertyChangeSupport.firePropertyChange("updateView", null, null);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void update(){
        propertyChangeSupport.firePropertyChange("update", null, null);
    }

    public void createNewGame(int gameMode){
        gameClient.createNewGame(gameMode);
        update();
    }

    public void playerTurn(int place){
        gameClient.playerTurn(place);
        update();
    }

    public State getCurrentState(){ return gameClient.getCurrentState(); }

    public Board getSelectedBoard(){ return gameClient.getSelectedBoard(); }

    public int getSelectedBoardNumber(){ return gameClient.getSelectedBoardNumber(); }

    public Board getBoard(int row, int col){ return gameClient.getBoard(row, col); }
}
