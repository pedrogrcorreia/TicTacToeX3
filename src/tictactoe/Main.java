package tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import tictactoe.UI.graphic.GameGraphic;
import tictactoe.logic.GameClient;
import tictactoe.logic.GameObservable;

import java.util.Optional;

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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getButtonTypes().remove(ButtonType.OK);
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.getButtonTypes().add(ButtonType.YES);
            alert.setTitle("Quit");
            alert.setContentText(String.format("Quit?"));
            alert.initOwner(stage.getOwner());
            Optional<ButtonType> res = alert.showAndWait();

            if(res.isPresent()) {
                if(res.get().equals(ButtonType.CANCEL))
                    windowEvent.consume();
                else{
                    Platform.exit();
                    System.exit(0);
                }
            }

        });
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
