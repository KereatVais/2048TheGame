package Main;

public class BoardSaver {
    public BoardSaveFile saveFile;
    private Board board;

    public BoardSaver(Board board) {
        this.board = board;
    }

    public void save() {
        saveFile = board.createSaveFile();
    }

    public void undo() {
        if (saveFile != null) {
            saveFile.restore();
        }
    }
}
