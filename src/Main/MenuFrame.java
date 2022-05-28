package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements MyFrame {
    private int width;
    private int height;

    private JPanel mainPanel;
    private JPanel buttonPanel;

    private MyFrameDirector myFrameDirector;

    @Override
    public void createFrame() {
        width = 800;
        height = 800;

        initComponents();

        setVisible(true);
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        myFrameDirector = new MyFrameDirector();
    }

    @Override
    public void addButtons() {
        buttonPanel.setLayout(new GridLayout(2, 2, 50, 50));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        buttonPanel.setBackground(Color.decode("#323657"));

        mainPanel.add(buttonPanel);

        addButton4x4();
        addButton5x5();
        addButton6x6();
        addButton7x7();
    }

    public void addButton4x4() {
        JButton button4x4 = new JButton("4x4");
        buttonPanel.add(button4x4);
        button4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardFrame boardFrame = new BoardFrame();
                myFrameDirector.makeFrame(boardFrame, 4, 4);
            }
        });
    }

    public void addButton5x5() {
        JButton button5x5 = new JButton("5x5");
        buttonPanel.add(button5x5);
        button5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardFrame boardFrame = new BoardFrame();
                myFrameDirector.makeFrame(boardFrame, 5, 5);
            }
        });
    }

    public void addButton6x6() {
        JButton button6x6 = new JButton("6x6");
        buttonPanel.add(button6x6);
        button6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardFrame boardFrame = new BoardFrame();
                myFrameDirector.makeFrame(boardFrame, 6, 6);
            }
        });
    }

    public void addButton7x7() {
        JButton button7x7 = new JButton("7x7");
        buttonPanel.add(button7x7);
        button7x7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardFrame boardFrame = new BoardFrame();
                myFrameDirector.makeFrame(boardFrame, 7, 7);
            }
        });
    }

    @Override
    public void addGraphics() {
        addMainPanel();
        addTitle();
    }

    @Override
    public void addBoard(int rowCount, int columnCount) {};

    private void addMainPanel() {
        add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#323657"));
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
    }

    private void addTitle() {
        JLabel title1 = new JLabel("2048");
        title1.setForeground(Color.WHITE);
        title1.setFont(new Font("SansSerif", Font.BOLD, 24));
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title2 = new JLabel("The game");
        title2.setForeground(Color.WHITE);
        title2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(title1);
        mainPanel.add(title2);
    }

    @Override
    public void closeFrame() {

    }
}
