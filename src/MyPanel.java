import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class MyPanel extends JPanel implements MouseListener {
    public static MyFrame yboard;
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

       /* int row = MyFrame.theBoard.length-1;

        while(row>=3){

            if(MyFrame.theBoard[row][column].equals(Color.white)){

                return row;
            }
            row--;

        }

        */
        for(int i = 1; i <= 5; i++)
        {
            if(!MyFrame.theBoard[i][column].equals(Color.white))
            {
                return i-1;
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



                MyFrame.theBoard[clickRow][clickCol] = Color.yellow;
                OwnAI.board();
                revalidate();
                repaint();
                //mediumAI.bestMove();
                //mediumAI.Board();
                //MyFrame.theBoardCopy[clickRow][clickCol] = 1;



                //MyFrame.theBoard[clickRow][clickCol] = Color.red;

                //
                //mediumAI.AI();
                //SimpleAI.simpleAI();


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
