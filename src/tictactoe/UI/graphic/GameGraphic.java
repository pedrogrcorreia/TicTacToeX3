package tictactoe.UI.graphic;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictactoe.UI.graphic.states.NewGamePane;
import tictactoe.UI.graphic.states.PlayerTurnPane;
import tictactoe.logic.GameObservable;

import java.io.File;

public class GameGraphic extends BorderPane {

    private GameObservable gameObservable;

    private NewGamePane newGamePane;
    private PlayerTurnPane playerTurnPane;

    private MenuItem load;
    private MenuItem save;
    private MenuItem rules;
    private MenuItem author;
    private MenuItem quitGame;
    private MenuItem quitSave;


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

        MenuBar menuBar = new MenuBar();
        setTop(menuBar);

        Menu file = new Menu("_File");

        load = new MenuItem("Load game");
        save = new MenuItem("Save game");
        file.getItems().addAll(load, save);

        Menu about = new Menu("_About");

        rules = new MenuItem("Rules");
        author = new MenuItem("Author");

        about.getItems().addAll(rules, author);

        Menu quit = new Menu("_Quit");

        quitGame = new MenuItem("Quit");
        quitSave = new MenuItem("Quit and Save");

        quit.getItems().addAll(quitGame, quitSave);

        createMenuActions();

        menuBar.getMenus().addAll(file, about, quit);
    }

    private void registerObserver(){
        gameObservable.addPropertyChangeListener("update", e->update());
    }

    private void createDialog(){
        Dialog<Boolean> dialog = new Dialog();
        dialog.setTitle("Winner");
        dialog.setHeaderText("Player " + gameObservable.getWinner().toString() + " won the game!");
        dialog.setContentText("Want to play again?");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.YES) {
                gameObservable.createNewGame(gameObservable.getGameMode());
            } else{
                gameObservable.endGame();
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void createMenuActions(){
        load.setOnAction(e-> {
            //new Alert(Alert.AlertType.INFORMATION, "To be developed", ButtonType.OK).show();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                try{
                    if(!gameObservable.loadGame(selectedFile)){
                        new Alert(Alert.AlertType.ERROR, "Error loading game!", ButtonType.OK).show();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        save.setOnAction(e-> {
            //new Alert(Alert.AlertType.INFORMATION, "To be developed", ButtonType.OK).show();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File selectedFile = fileChooser.showSaveDialog(null);
            if(selectedFile != null){
                if(!gameObservable.saveGame(selectedFile)){
                    new Alert(Alert.AlertType.ERROR, "Error saving the game", ButtonType.OK).show();
                }
            }
        });

        rules.setOnAction(e-> {
            new Alert(Alert.AlertType.INFORMATION, "To be developed", ButtonType.OK).show();
        });

        author.setOnAction(e-> {
            new Alert(Alert.AlertType.INFORMATION, "To be developed", ButtonType.OK).show();
        });

        quitGame.setOnAction(e-> {
            Stage window = (Stage) this.getScene().getWindow();
            fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
        });

        quitSave.setOnAction(e-> {
            new Alert(Alert.AlertType.INFORMATION, "To be developed", ButtonType.OK).show();
        });
    }

    private void update(){
        switch(gameObservable.getCurrentState()){
            case NEW_GAME -> setCenter(newGamePane);
            case PLAYER_TURN -> setCenter(playerTurnPane);
            case END_GAME -> createDialog();
            case PC_TURN -> gameObservable.pcTurn();
        }
    }
}
