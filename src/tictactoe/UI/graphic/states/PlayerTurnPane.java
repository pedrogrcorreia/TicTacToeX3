package tictactoe.UI.graphic.states;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import tictactoe.UI.graphic.BigBoardPane;
import tictactoe.logic.GameObservable;
import tictactoe.logic.State;

public class PlayerTurnPane extends BorderPane {

    private GameObservable gameObservable;
    private BigBoardPane bigBoardPane;
    private HBox hBox;

    public PlayerTurnPane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        registerObserver();
        update();
    }

    private void createWindow(){
        hBox = new HBox(20);
        bigBoardPane = new BigBoardPane(gameObservable);
        setCenter(bigBoardPane);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void update(){
        bigBoardPane = new BigBoardPane(gameObservable);
        setCenter(bigBoardPane);
        setVisible(gameObservable.getCurrentState() == State.PLAYER_TURN || gameObservable.getCurrentState() == State.END_GAME);
    }
}
