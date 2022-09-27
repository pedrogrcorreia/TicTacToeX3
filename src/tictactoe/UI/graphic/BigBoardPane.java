package tictactoe.UI.graphic;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import tictactoe.logic.Data.GameInfo.Board;
import tictactoe.logic.Data.GameInfo.Player;
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

        InputStream urlBoard = getClass().getResourceAsStream("resources/images/TicTacToe-SVG.jpeg");
        Image imageBoard = new Image(urlBoard);
        BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage backgroundImageBoard = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImageBoard);

        InputStream urlX = getClass().getResourceAsStream("resources/images/X.png");
        Image imageX = new Image(urlX);
        BackgroundImage backgroundImageX = new BackgroundImage(imageX, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundX = new Background(backgroundImageX);

        InputStream urlO = getClass().getResourceAsStream("resources/images/O.png");
        Image imageO = new Image(urlO);
        BackgroundImage backgroundImageO = new BackgroundImage(imageO, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundO = new Background(backgroundImageO);

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                BoardPane b = new BoardPane(this);
                Board board = gameObservable.getBoard(j, i);
                if(board.isWon()){
                    if(board.getWinner() == Player.PLAYER_X){
                        b.setBackground(backgroundX);
                    } else{
                        b.setBackground(backgroundO);
                    }
                    add(b, i, j);
                    continue;
                }
                if(board.getActive()){
                    int row = j;
                    int col = i;
                    b.setBackground(background);
                    b.drawSelectedBoard(board);
                    b.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
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
