package tictactoe.UI.graphic;

import javafx.scene.layout.BorderPane;
import tictactoe.UI.graphic.states.NewGamePane;
import tictactoe.UI.graphic.states.PlayerTurnPane;
import tictactoe.logic.GameObservable;

public class GameGraphic extends BorderPane {

    private GameObservable gameObservable;

    private NewGamePane newGamePane;
    private PlayerTurnPane playerTurnPane;

    public GameGraphic(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        registerObserver();
        update();
    }

    private void createWindow(){
        newGamePane = new NewGamePane(gameObservable);
        playerTurnPane = new PlayerTurnPane(gameObservable);
        setCenter(newGamePane);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void update(){
        System.out.println(gameObservable.getCurrentState());
        switch(gameObservable.getCurrentState()){
            case NEW_GAME -> setCenter(newGamePane);
            case PLAYER_TURN -> setCenter(playerTurnPane);
        }
    }
}
