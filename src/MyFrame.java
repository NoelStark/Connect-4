import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame{
    public static MyPanel panel2;
    public static Color[][] theBoard = new Color[6][7];



    public MyFrame(){
        panel2 = new MyPanel();
        JFrame frame = new JFrame("Demo");
            JPanel panel = new JPanel(new BorderLayout());
            JPanel layout = new JPanel(new GridBagLayout());
            layout.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel btnPanel = new JPanel(new GridLayout(2, 2, 30, 30));


            JButton btn1 = new JButton("Multiplayer");
            btn1.addActionListener(e->{
                MyPanel.multiplayer = true;
                frame.setContentPane(panel2);
                frame.invalidate();
                frame.validate();
                frame.setBackground(Color.black);
            });

            JButton btn2 = new JButton("Easy AI");
            btn2.addActionListener(e->{
                MyPanel.easy = true;
                frame.setContentPane(panel2);
                frame.invalidate();
                frame.validate();
                frame.setBackground(Color.black);

            });

            JButton btn3 = new JButton("Medium AI");
            btn3.addActionListener(e->{
                MyPanel.medium = true;
                frame.setContentPane(panel2);
                frame.invalidate();
                frame.validate();
                frame.setBackground(Color.black);

            });

            JButton btn4 = new JButton("Hard AI");
            btn4.addActionListener(e->{
            MyPanel.hard = true;
            frame.setContentPane(panel2);
            frame.invalidate();
            frame.validate();
            frame.setBackground(Color.black);

            });


            btnPanel.add(btn1);
            btnPanel.add(btn2);
            btnPanel.add(btn3);
            btnPanel.add(btn4);
            layout.add(btnPanel);
            panel.add(layout, BorderLayout.CENTER);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(435, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


    }

}
