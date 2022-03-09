import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MyPanel extends JPanel implements MouseListener {
    public static int player = 2;
    MyPanel()
    {
        setPreferredSize(new Dimension(421,362));
        addMouseListener(this);
        for(int i = 0; i < MyFrame.theBoard.length;i++)
        {
            for(int j = 0; j < MyFrame.theBoard[0].length;j++)
            {
                MyFrame.theBoard[i][j] = Color.white;
            }
        }
    }

@Override
   public void paintComponent(Graphics g)
   {

       Graphics2D g2 = (Graphics2D) g;


       int x = 0;
       int y = 0;
       for(int i = 0; i < MyFrame.theBoard.length; i++)
       {
           for(int j = 0; j < MyFrame.theBoard[0].length;j++)
           {


               g2.setColor(MyFrame.theBoard[i][j]);
               g2.fillOval(x,y,60,60);
               g2.setColor(Color.black);
               g2.drawOval(x,y,60,60);
               x = x + 60;
           }
           y = y + 60;
           x = 0;
       }
   }

    public static int dropP(int column){

        for(int i = 5; i >= 0; i--)
        {

            if(MyFrame.theBoard[i][column].equals(Color.white))
                return i;
        }


        return 5;

    }
    public static int dropN(int column){

        for(int i = 0; i < 6; i++)
        {
            if(OwnAI.arr[i][column] == 1 || OwnAI.arr[i][column] == -1)
            {

                if(i != 0)
                {
                    return i-1;
                }
                else{
                    return i;
                }
            }

        }


        return 5;

    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        if(CheckWinner.winner)
        {
            removeMouseListener(this);
        }
        else{


        int x = e.getX();
        int clickRow;
        int clickCol = x/60;
        clickRow = dropP(clickCol);
            if(Arrays.stream(MyFrame.theBoard).flatMap(Arrays::stream).noneMatch(value -> value == Color.yellow|| value == Color.red)) {
                MyFrame.theBoard[5][3] = Color.yellow;
            }

            /*if(MyFrame.theBoard[clickRow][clickCol] == Color.white)
            {


                MyFrame.theBoard[clickRow][clickCol] = Color.yellow;

                //SimpleAI.simpleAI();
                OwnAI.board(2);
                revalidate();
                repaint();
            }

             */
            while(Arrays.stream(MyFrame.theBoard).flatMap(Arrays::stream).anyMatch(value -> value == Color.white))
            {
                OwnAI.board(2);
                OwnAI.board(1);
            }

            revalidate();
            repaint();

            CheckWinner.checkWinner(Color.red);
            CheckWinner.checkWinner(Color.yellow);



        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
