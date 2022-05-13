import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class MyPanel extends JPanel implements MouseListener {
    public static int player = 1;
    public static boolean alreadyExecuted;
    public static boolean multiplayer = false, easy = false, medium = false, hard = false;
    MyPanel()
    {

        addMouseListener(this);
        for(int i = 0; i < MyFrame.theBoard.length;i++) //Gör brädet vitt
        {
            for(int j = 0; j < MyFrame.theBoard[0].length;j++)
            {
                MyFrame.theBoard[i][j] = Color.white;
            }
        }
        JButton btn1 = new JButton("Reset");
        this.setLayout(null);
        btn1.setBounds(430,200,80,40);
        btn1.addActionListener(e->{
            MyFrame.frame.setVisible(false);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            CheckWinner.winner = false;
            multiplayer = easy = medium = hard = false;
            new MyFrame();
        });
        this.add(btn1);

    }

@Override
   public void paintComponent(Graphics g)
   {

       Graphics2D g2 = (Graphics2D) g;


       int x = 0;
       int y = 0;
       for(int i = 0; i < MyFrame.theBoard.length; i++) //ritar brädet
       {
           for(int j = 0; j < MyFrame.theBoard[0].length;j++)
           {


               g2.setColor(MyFrame.theBoard[i][j]);
               g2.fillOval(x,y,60,60); //Skapar cirklar
               g2.setColor(Color.black); //Gör området omkring cirklarna svart
               g2.drawOval(x,y,60,60); //ritar ut dem
               x = x + 60;
           }
           y = y + 60;
           x = 0;
       }
   }

   //Metoden som släpper brickorna längst ner i en kolumn
    public static int dropP(int column){

        for(int i = 5; i >= 0; i--)
        {

            if(MyFrame.theBoard[i][column].equals(Color.white))
                return i;
        }


        return 0;

    }
    //Metoden som släpper siffororna i arr[][] för att spegla brädet
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

        if(CheckWinner.winner) //Om det finns en vinnare eller spelet är oavgjort
        {
            removeMouseListener(this);
        }
        else{


        int x = e.getX();//Får X-koordinaten baserat på vart spelare har tryckt
        int clickRow;
        int clickCol = x/60;
        clickRow = dropP(clickCol);


            CheckWinner.checkWinner(Color.red);
            CheckWinner.checkWinner(Color.yellow);
            if(MyFrame.theBoard[clickRow][clickCol] == Color.white)
            {
                alreadyExecuted = false;
                MyFrame.theBoard[clickRow][clickCol] = Color.yellow;
                if(multiplayer) //Om användare valt tvåspelar läget
                {

                    if(player == 2)//Om gult nyss spelat
                    {
                        MyFrame.theBoard[clickRow][clickCol] = Color.red; //Röds tur
                        player = 1;
                    }
                    else
                    {
                        MyFrame.theBoard[clickRow][clickCol] = Color.yellow; //guls tur
                        player = 2;
                    }


                }
                else if(easy) //Om användare valt Easy AI
                {

                    SimpleAI.simpleAI();

                }
                else if(medium) //Om användare valt Medium AI
                {

                    OwnAI.board(Color.yellow);
                }
                else if(hard)//Om användare valt Hard AI
                {
                    HardAI.board();
                }

            }

            CheckWinner.checkWinner(Color.red);
            CheckWinner.checkWinner(Color.yellow);
            revalidate();
            repaint();




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
