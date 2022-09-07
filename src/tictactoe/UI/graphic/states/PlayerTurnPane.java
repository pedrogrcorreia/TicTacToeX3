package tictactoe.UI.graphic.states;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tictactoe.UI.graphic.BigBoardPane;
import tictactoe.UI.graphic.BoardPane;
import tictactoe.logic.GameObservable;
import tictactoe.logic.State;

public class PlayerTurnPane extends BorderPane {

    private GameObservable gameObservable;

    private GridPane gridPaneOne;
    private GridPane gridPaneTwo;
    private BoardPane boardPane;
    private BigBoardPane bigBoardPane;
    private HBox hBox;

    public PlayerTurnPane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        registerObserver();
        update();
    }

    private void createWindow(){
        Label debug = new Label("Active board: " + gameObservable.getSelectedBoardNumber());
        setTop(debug);

        hBox = new HBox(20);
//        gridPaneOne = new GridPane();
//        gridPaneTwo = new GridPane();
//
//        gridPaneOne.setGridLinesVisible(true);
//        gridPaneTwo.setGridLinesVisible(true);
//
//        gridPaneOne.setAlignment(Pos.CENTER);
//        gridPaneOne.setHgap(10);
//        gridPaneOne.setVgap(10);
//        ColumnConstraints column1 = new ColumnConstraints();
//        column1.setPercentWidth(50);
//        ColumnConstraints column2 = new ColumnConstraints();
//        column2.setPercentWidth(50);
//        gridPaneOne.getColumnConstraints().addAll(column1, column2);

//        hBox.getChildren().addAll(gridPaneOne, gridPaneTwo);
//        boardPane = new BoardPane(gameObservable);
        bigBoardPane = new BigBoardPane(gameObservable);
        setCenter(bigBoardPane);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void update(){
//        boardPane = new BoardPane(gameObservable);
//        setCenter(boardPane);
        bigBoardPane = new BigBoardPane(gameObservable);
        setCenter(bigBoardPane);
        setVisible(gameObservable.getCurrentState() == State.PLAYER_TURN);
    }
}
