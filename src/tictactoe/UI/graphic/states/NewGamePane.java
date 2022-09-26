package tictactoe.UI.graphic.states;

import javafx.geometry.Pos;
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
        btnSingle = new Button("Multi Player");
        btnMulti = new Button("Single Player (vs PC)");

        btnSingle.setOnAction(e -> gameObservable.createNewGame(0));

        btnMulti.setOnAction(e -> gameObservable.createNewGame(1));

        layout = new VBox(10);
        layout.setSpacing(20);
        layout.getChildren().addAll(btnSingle, btnMulti);
        layout.setAlignment(Pos.CENTER);

        setCenter(layout);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void update(){
        setVisible(gameObservable.getCurrentState() == State.NEW_GAME);
    }
}
