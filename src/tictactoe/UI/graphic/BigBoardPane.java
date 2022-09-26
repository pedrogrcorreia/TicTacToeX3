package tictactoe.UI.graphic;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.GameObservable;

import java.io.InputStream;

public class BigBoardPane extends GridPane {

    private GameObservable gameObservable;

    private int playBoard;
    private int place;

    public BigBoardPane(GameObservable gameObservable){
        this.gameObservable = gameObservable;
        createWindow();
        drawBigBoard();
    }

    private void createWindow(){
        setAlignment(Pos.CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33);
        getColumnConstraints().addAll(column1, column2, column3); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(33);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(33);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(33);
        getRowConstraints().addAll(row1, row2, row3);
    }

    private void drawBigBoard(){
//        setGridLinesVisible(true);

        InputStream url = getClass().getResourceAsStream("resources/images/TicTacToe-SVG.jpeg");
        Image image = new Image(url);
        BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                BoardPane b = new BoardPane(this);
                Board board = gameObservable.getBoard(j, i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("Board " + j + " " + i + " " + board.getActive());
                if(board.getActive()){
                    int row = j;
                    int col = i;
                    b.setBackground(background);
                    b.drawSelectedBoard(board);
                    b.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(3))));
                    b.setOnMouseClicked(e->{
                        playBoard = row*3+col;
                        if(b.isPlaceSet()) {
                            play(b.getPlace());
                        }
                    });
                    add(b, i, j);
                    continue;
                }
                b.drawBoard(board);
                b.setBackground(background);
                add(b, i, j);
            }
        }
    }

    public void setPlace(int place){
        this.place = place;
    }

    public void play(int place){
        gameObservable.playerTurn(place, playBoard);
    }

    public int getPlayBoard(){
        return playBoard;
    }
}
