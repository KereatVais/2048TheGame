package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BoardFrame extends JFrame implements MyFrame, KeyListener {
    private Board board;
    private BoardSaver boardSaver;

    private int width;
    private int height;

    private JPanel mainPanel;
    private SpringLayout layout;

    private JButton undoButton;
    private JButton newGameButton;

    private Context context;

    @Override
    public void createFrame() {
        width = 800;
        height = 800;

        initComponents();

        setVisible(true);
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addKeyListener(this);
    }

    private void initComponents() {
        context = new Context();
        layout = new SpringLayout();
        mainPanel = new JPanel();
    }

    @Override
    public void addButtons() {
        addUndoButton();
        addNewGameButton();
    }

    private void addUndoButton() {
        undoButton = new JButton("Undo");
        layout.putConstraint(SpringLayout.EAST, undoButton, -100, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, undoButton, 40, SpringLayout.NORTH, mainPanel);
        mainPanel.add(undoButton);

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.boardSaver.undo();
            }
        });

        undoButton.setFocusable(false);
    }

    private void addNewGameButton() {
        newGameButton = new JButton("New game");
        layout.putConstraint(SpringLayout.EAST, newGameButton, -50, SpringLayout.WEST, undoButton);
        layout.putConstraint(SpringLayout.NORTH, newGameButton, 40, SpringLayout.NORTH, mainPanel);
        mainPanel.add(newGameButton);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame();
            }
        });

        newGameButton.setFocusable(false);
    }

    @Override
    public void addGraphics() {
        addMainPanel();
        addScoreLabel();
    }

    private void addMainPanel() {
        mainPanel.setLayout(layout);
        mainPanel.setBackground(Color.decode("#323657"));
        add(mainPanel);
    }

    @Override
    public void addBoard(int rowCount, int columnCount) {
        board = new Board(rowCount, columnCount);
        boardSaver = board.getBoardSaver();

        layout.putConstraint(SpringLayout.WEST, board, 100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, board, 100, SpringLayout.NORTH, mainPanel);
        mainPanel.add(board);
    }

    private void addScoreLabel() {
        mainPanel.add(board.scoreLabel);
        layout.putConstraint(SpringLayout.WEST, board.scoreLabel, 100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, board.scoreLabel, 40, SpringLayout.NORTH, mainPanel);
    }

    @Override
    public void closeFrame() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            context.setStrategy(new MoveUpStrategy(), board);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            context.setStrategy(new MoveDownStrategy(), board);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            context.setStrategy(new MoveLeftStrategy(), board);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            context.setStrategy(new MoveRightStrategy(), board);
        }
        context.executeStrategy();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
