package tictactoe.UI.graphic;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import tictactoe.logic.Data.GameInfo.BigBoard;
import tictactoe.logic.GameObservable;

import static javafx.scene.paint.Color.BLUE;

public class BigBoardPane extends GridPane {

    private GameObservable gameObservable;

    public BigBoardPane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        drawBigBoard();
    }

    private void createWindow(){
        setAlignment(Pos.CENTER);
        setVgap(10);
        setHgap(10);
        setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(5))));
//        for(int i = 0; i<3; i++) {
//            ColumnConstraints columnConstraints = new ColumnConstraints(33);
//            getColumnConstraints().add(columnConstraints);
//        }
    }

    private void drawBigBoard(){
        setGridLinesVisible(true);
        int active = gameObservable.getSelectedBoardNumber();
        int row = active / 3;
        int col = active % 3;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                BoardPane b = new BoardPane(gameObservable);
                if(row == j && col == i){
                    b.setBackground(new Background(new BackgroundFill(BLUE, null, null)));
                    b.drawSelectedBoard(gameObservable.getBoard(j, i));
                    b.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(5))));
                    add(b, i, j);
                    continue;
                }
                b.drawBoard(gameObservable.getBoard(j, i));
                b.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY, new BorderWidths(5))));
                add(b, i, j);
            }
        }
    }
}
