package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Представляют собой клетку
 * @author KereatVais
 */
public class Tile extends JPanel {
    private Color tileColor;
    private Color textColor;
    private Font tileFont;

    private int weight;

    private JLabel weightLabel;

    /**
     * Конструктор без параметров, который создает пустую клетку
     */
    public Tile() {
        this(0);
    }

    /**
     * Конструктор с параметрами, который создает клетку с заданным весом
     * @param weight - вес клетки
     */
    public Tile(int weight) {
        this.weight = weight;

        weightLabel= new JLabel(String.valueOf(weight), SwingConstants.CENTER);
        weightLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        add(weightLabel, BorderLayout.CENTER);

        tileFont = new Font("Tahoma", Font.BOLD, 32);

        update(weight);
    }

    /**
     * Заменяет вес клетки соответствующим числом и изменяет вид клетки в соответствие с весом
     * @param num - число, которым заменяется текущий вес
     */
    public void update(int num) {
        weight = num;
        weightLabel.setText(num == 0? " " : String.valueOf(weight));
        defineColor(num);
    }

    /**
     * Определяет цвет клетки в зависимости от веса
     * @param weight - вес
     */
    public void defineColor(int weight) {
        switch (weight) {
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

    /**
     * Возвращает вес клетки
     * @return вес клетки
     */
    public int getWeight() {
        return weight;
    }

}
