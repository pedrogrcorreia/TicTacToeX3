package tictactoe.UI.graphic;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.GameObservable;

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
//        for(int i = 0; i<3; i++) {
//            ColumnConstraints columnConstraints = new ColumnConstraints(50);
//            getColumnConstraints().add(columnConstraints);
//        }
//        for(int i = 0; i<3; i++){
//            RowConstraints rowConstraints = new RowConstraints(100);
//            getRowConstraints().add(rowConstraints);
//        }
    }

    public void drawBoard(Board b){
        setGridLinesVisible(true);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                final int row = j;
                final int col = i;
                String[][] board = b.getStringBoard();
                Label lbl = new Label(board[j][i]);
                lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY, new BorderWidths(1))));
                add(lbl, i, j);
            }
        }
    }

    public void drawSelectedBoard(Board b){
        setGridLinesVisible(true);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                final int row = j;
                final int col = i;
                String[][] board = b.getStringBoard();
                Label lbl = new Label(board[j][i]);
                lbl.setOnMouseClicked(e->{
                    gameObservable.playerTurn(row*3+col);
                    System.out.println(row + " " + col + "\n");
                });
                Rectangle rec = new Rectangle();
                add(lbl, i, j);
            }
        }
    }
}
