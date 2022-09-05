package States;

public interface IState {

    IState createNewGame();

    IState initialOption(int opt);

    IState playerTurn(int place);


}
