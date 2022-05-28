package Main;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private Color tileColor;
    private Color textColor;
    private Font tileFont = new Font("SansSerif", Font.BOLD, 32);

    private int weight;                 //число, написанное на клетке, назовем это "вес"

    public int width;

    public JLabel weightLabel;

    public Tile() {
        this(0);
    }

    public Tile(int weight) {
        this.weight = weight;

        weightLabel= new JLabel(String.valueOf(weight), SwingConstants.CENTER);
        weightLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        add(weightLabel);

        update(weight);
    }

    public void update(int num) {
        weight = num;
        weightLabel.setText(num == 0? " " : String.valueOf(weight));
        defineColor(num);
    }

    public void defineColor(int num) {
        switch (num) {
            case 0:
                tileColor = Color.decode("#898EB3");
                textColor = Color.BLACK;
                break;
            case 2:
                tileColor = Color.decode("#E7DAAD");
                textColor = Color.BLACK;
                break;
            case 4:
                tileColor = Color.decode("#F0D77F");
                textColor = Color.BLACK;
                break;
            case 8:
                tileColor = Color.decode("#EEC637");
                textColor = Color.BLACK;
                break;
            case 16:
                tileColor = Color.decode("#EE9D37");
                textColor = Color.BLACK;
                break;
            case 32:
                tileColor = Color.decode("#EE714C");
                textColor = Color.WHITE;
                break;
            case 64:
                tileColor = Color.decode("#FF2B00");
                textColor = Color.WHITE;
                break;
            case 128:
                tileColor = Color.decode("#FA3E58");
                textColor = Color.WHITE;
                break;
            case 256:
                tileColor = Color.decode("#E70019");
                textColor = Color.WHITE;
                break;
            case 512:
                tileColor = Color.decode("#B80026");
                textColor = Color.WHITE;
                break;
            case 1024:
                tileColor = Color.decode("#C4006F");
                textColor = Color.WHITE;
                break;
            case 2048:
                tileColor = Color.decode("#C4F3F3");
                textColor = Color.WHITE;
                break;
        }
        setBackground(tileColor);
        weightLabel.setForeground(textColor);
        weightLabel.setFont(tileFont);
    }

    public int getWeight() {
        return weight;
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

}
