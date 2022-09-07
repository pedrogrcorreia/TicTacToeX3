package tictactoe.UI.graphic;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.GameObservable;

import java.io.InputStream;

import static javafx.scene.paint.Color.BLUE;

public class BoardPane extends GridPane {

    private GameObservable gameObservable;

    public BoardPane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
//        drawBoard(gameObservable);
    }

    private void createWindow(){
        setAlignment(Pos.CENTER);
        setVgap(0);
        setHgap(0);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        getColumnConstraints().addAll(column1, column2, column3); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(33);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(33);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(33);
        getRowConstraints().addAll(row1, row2, row3);
    }

    public void drawBoard(Board b){
//        setGridLinesVisible(true);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
//                final int row = j;
//                final int col = i;
                String[][] board = b.getStringBoard();
//                Label lbl = new Label(board[j][i]);
//                setValignment(lbl, VPos.CENTER);
//                setHalignment(lbl, HPos.CENTER);
//                add(lbl, i, j);
                if(board[j][i] == "*"){
                    emptyCell(j, i);
                }else{
                    filledCell(j, i, board[j][i]);
                }
            }
        }
    }

    public void drawSelectedBoard(Board b){
        InputStream xurl = getClass().getResourceAsStream("resources/images/X.png");
        Image x = new Image(xurl);
        InputStream ourl = getClass().getResourceAsStream("resources/images/O.png");
        Image o = new Image(ourl);
        setGridLinesVisible(true);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                String[][] board = b.getStringBoard();
                if(board[j][i] == "*"){
                    emptyActiveCell(j, i);
                }else{
                    filledCell(j, i, board[j][i]);
                }
//                pane.setAlignment(Pos.CENTER);
//                pane.getChildren().add(lbl);
//                pane.setOnMouseClicked(e->{
//                    gameObservable.playerTurn(row*3+col);
//                    System.out.println(row + " " + col + "\n");
//                });
//                add(pane, i, j);
            }
        }
    }

    private void emptyActiveCell(int row, int col){
        StackPane pane = (StackPane) createPane();
        pane.setOnMouseClicked(e->{
            gameObservable.playerTurn(row*3+col);
        });
        add(pane, col, row);
    }

    private void emptyCell(int row, int col){
        StackPane pane = (StackPane) createPane();
        add(pane, col, row);
    }

    private void filledCell(int row, int col, String player){
        StackPane pane = (StackPane) createPane();
        Label lbl = new Label(player);
        pane.getChildren().add(lbl);
        add(pane, col, row);
    }

    private Pane createPane(){
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
}
