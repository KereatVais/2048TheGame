package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    public int width;
    public int height;

    //public static final int BORDER = 20;         //отступ между клетками

    int border;
    int tileWidth;

    private Tile[][] tiles;

    private int rowCount;
    private int columnCount;

    private int score;      //счет в игре
    public JLabel scoreLabel;

    public BoardSaver boardSaver;      //класс, управляющий сохранением, для текущего экземпляра доски

    public Board() {
        this(4, 4);
    }

    public Board(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        defineSize();

        tiles = createNewTiles(rowCount, columnCount);
        setTileSize();
        addTilesToBoard();

        addScoreLabel();

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.decode("#041228"));
        setLayout(new FlowLayout(FlowLayout.LEADING, border, border));

        generateNewTile();

        boardSaver = new BoardSaver(this);
    }

    public void addScoreLabel() {
        score = 0;
        scoreLabel = new JLabel("Score: " + Integer.toString(score));
        scoreLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        scoreLabel.setForeground(Color.WHITE);
    }

    // добавляет к полю score величину num
    // и апдейтит jlabel, на котором отображается поле score
    public void updateScore(int num) {
        score += num;
        scoreLabel.setText("Score: " + Integer.toString(score + num));
    }

    public void defineSize() {
        width = 600;
        height = 600;
        if (rowCount == 4 && columnCount == 4) {
            tileWidth = 120;
            border = 24;
        } else if (rowCount == 5 && columnCount == 5) {
            tileWidth = 96;
            border = 20;
        } else if (rowCount == 6 && columnCount == 6) {
            tileWidth = 86;
            border = 12;
        } else if (rowCount == 7 && columnCount == 7) {
            tileWidth = 72;
            border = 12;
        }
    }

    public void setTileSize() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                tiles[i][j].width = tileWidth;
                tiles[i][j].setPreferredSize(new Dimension(tileWidth, tileWidth));
            }
        }
    }

    //добавляет this.tiles к текущему экземпляру класса Board
    public void addTilesToBoard() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                this.add(tiles[i][j]);
            }
        }

    }

    //создание нового пустого tiles
    //rowCount - количество строк
    //columnCount - количество столбцов
    public Tile[][] createNewTiles(int rowCount, int columnCount) {
        Tile[][] tiles = new Tile[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                tiles[i][j] = new Tile();
            }
        }
        return tiles;
    }

    // апдейт tiles в текущем экземпляре класса Board
    // src - из какой доски берем данные
    public void update(Tile[][] src) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                this.tiles[i][j].update(src[i][j].getWeight());
            }
        }
    }

    // апдейт
    // src - из какого tiles берем данные
    // dest - какой tiles изменяем
    public void update(Tile[][] src, Tile[][] dest) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                dest[i][j].update(src[i][j].getWeight());
            }
        }
    }

    public void reset(Tile[][] tiles) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                tiles[i][j].update(0);
            }
        }
    }

    public BoardSaveFile createSaveFile() {
        return new BoardSaveFile(this, tiles, rowCount, columnCount);
    }

    public void newGame() {
        reset(tiles);
        generateNewTile();
        boardSaver.save();
    }

    public void copy(Tile[][] src, Tile[][] dest) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                dest[i][j].update(src[i][j].getWeight());
            }
        }
    }

    public void generateNewTile() {
        ArrayList<Tile> emptyTiles = new ArrayList<Tile>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (tiles[i][j].getWeight() == 0)
                    emptyTiles.add(tiles[i][j]);
            }
        }
        int newTileIdx = (int) (Math.random() * emptyTiles.size()); //определяем место появления новой клетки
        int newTileNumber = ((int) (Math.random() * 2)) == 0? 2 : 4; //определяем будет 2 или 4 (50 на 50)
        emptyTiles.get(newTileIdx).update(newTileNumber);
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public BoardSaver getBoardSaver() {
        return boardSaver;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) { this.score = score;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }
}
