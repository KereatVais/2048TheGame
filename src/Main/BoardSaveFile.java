package Main;

public class BoardSaveFile {
    private Board board;
    public Tile[][] tiles;
    private int rowCount;
    private int columnCount;

    public BoardSaveFile(Board board, Tile[][] tiles, int rowCount, int columnCount) {
        this.board = board;

        this.tiles = board.createNewTiles(rowCount, columnCount);
        board.update(tiles, this.tiles);

        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public void restore() {
        board.setRowCount(rowCount);
        board.setColumnCount(columnCount);
        board.update(tiles);
    }
}
