package Main;

import javax.swing.*;

public class MoveLeftStrategy implements Strategy{
    public void execute(Board board) {
        int rowCount = board.getRowCount();
        int columnCount = board.getColumnCount();
        Tile[][] tiles = board.getTiles();

        int j;
        for (int i = 0; i < rowCount; i++) {
            j = 0;
            while (j < columnCount - 1) {
                if (tiles[i][j].getWeight() == tiles[i][j + 1].getWeight()) {
                    int doubleWeight = tiles[i][j].getWeight() * 2;
                    board.updateScore(doubleWeight);
                    tiles[i][j].update(doubleWeight);
                    tiles[i][j + 1].update(0);
                }
                j++;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            j = 1;
            while (j < columnCount) {
                if (j != 0 && tiles[i][j - 1].getWeight() == 0 && tiles[i][j].getWeight() != 0) {
                    tiles[i][j - 1].update(tiles[i][j].getWeight());
                    tiles[i][j].update(0);
                    j--;

                    if (j != 0 && tiles[i][j].getWeight() == tiles[i][j - 1].getWeight()) {
                        int doubleWeight = tiles[i][j].getWeight() * 2;
                        board.updateScore(doubleWeight);
                        tiles[i][j - 1].update(doubleWeight);
                        tiles[i][j].update(0);
                    }
                }
                else {
                    j++;
                }
            }

        }
    }
}
