package Main;

public class Context {
    private Strategy strategy;
    private Board board;
    private BoardSaver boardSaver;

    public void setStrategy(Strategy strategy, Board board) {
        this.strategy = strategy;
        this.board = board;
        boardSaver = board.getBoardSaver();
    }

    public void executeStrategy() {
        boardSaver.save();
        strategy.execute(board);
        board.generateNewTile();
//        board.updateScore();
    }
}
