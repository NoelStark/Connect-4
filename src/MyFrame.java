import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame{
    public static MyPanel panel;
    public static Color[][] theBoard = new Color[6][7];
    public static char[][] theBoardCopy = new char[6][7];
    private static int player = 2;

    public MyFrame(){
        panel = new MyPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,139));
        this.setVisible(true);
    }


}
