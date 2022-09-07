package tictactoe.UI.graphic.states;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tictactoe.logic.GameObservable;
import tictactoe.logic.State;

public class NewGamePane extends BorderPane {

    private GameObservable gameObservable;

    private Button btnSingle;
    private Button btnMulti;
    private VBox layout;

    public NewGamePane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        registerObserver();
        update();
    }

    private void createWindow(){
        btnSingle = new Button("Single Player");
        btnMulti = new Button("Multiplayer");

        btnSingle.setOnAction(e -> gameObservable.createNewGame(0));

        btnMulti.setOnAction(e -> gameObservable.createNewGame(1));

        layout = new VBox(10);
        layout.setSpacing(20);
        layout.getChildren().addAll(btnSingle, btnMulti);

        setCenter(layout);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void update(){
        setVisible(gameObservable.getCurrentState() == State.NEW_GAME);
    }
}
