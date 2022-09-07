package tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.UI.graphic.GameGraphic;
import tictactoe.logic.GameClient;
import tictactoe.logic.GameObservable;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameClient gameClient = new GameClient();
        GameObservable gameObservable = new GameObservable(gameClient);
        GameGraphic gameGraphic = new GameGraphic(gameObservable);
        Scene scene = new Scene(gameGraphic, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToeX3");
        stage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    public static void main(String[] args){
//        GameClient gameClient = new GameClient();
//        ConsoleUI consoleUI = new ConsoleUI(gameClient);
//        consoleUI.run();
        launch(args);
    }
}
