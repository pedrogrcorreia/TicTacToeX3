package tictactoe.logic;

import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.Data.GameInfo.Player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import tictactoe.logic.Util.*;

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

    public void playerTurn(int place, int playBoard){
        gameClient.playerTurn(place, playBoard);
        update();
    }

    public void pcTurn(){
        gameClient.pcTurn();
        update();
    }

    public void endGame(){
        gameClient.endGame();
        update();
    }

    public State getCurrentState(){ return gameClient.getCurrentState(); }

    public Board getBoard(int row, int col){ return gameClient.getBoard(row, col); }

    public void setBoard(int nboard){
        update();
    }

    public Player getWinner(){
        return gameClient.getWinner();
    }

    public int getGameMode(){
        return gameClient.getGameMode();
    }

    public boolean loadGame(File filename){
        GameClient aux = Load.loadGame(filename);
        if(aux != null){
            gameClient = aux;
            update();
            return true;
        }
        return false;
    }

    public boolean saveGame(File filename){
        return Save.saveGame(gameClient, filename);
    }
}
