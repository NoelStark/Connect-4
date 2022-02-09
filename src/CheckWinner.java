import java.awt.*;

public class CheckWinner{

    public static boolean myFunction(Color r1)
    {
        for(int row = 0; row < MyFrame.theBoard.length; row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length; col++)
            {

            }
        }
        return false;
    }










    public static boolean diagonalP(Color r)
    {
        for(int i = 0;  i < MyFrame.theBoard.length-3;i++)
        {
            for(int j = 0; j < MyFrame.theBoard[0].length-3; j++)
            {

                if(MyFrame.theBoard[i][j].equals(r) && MyFrame.theBoard[i+1][j+1].equals(r) && MyFrame.theBoard[i+2][j+2].equals(r) && MyFrame.theBoard[i+3][j+3].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean diagonalN(Color r)
    {
        for(int i = 0;  i < MyFrame.theBoard.length-3;i++)
        {
            for(int j = 3; j < MyFrame.theBoard[0].length; j++)
            {

                if(MyFrame.theBoard[i][j].equals(r) && MyFrame.theBoard[i+1][j-1].equals(r) && MyFrame.theBoard[i+2][j-2].equals(r) && MyFrame.theBoard[i+3][j-3].equals(r))
                {
                    return true;

                }
            }
        }
        return false;
    }
    public static boolean vertical(Color r)
    {
        for(int i = 0;  i < MyFrame.theBoard.length -3;i++)
        {
            for(int j = 0; j < MyFrame.theBoard[0].length; j++)
            {
                if(MyFrame.theBoard[i][j].equals(r) && MyFrame.theBoard[i+1][j].equals(r) && MyFrame.theBoard[i+2][j].equals(r) && MyFrame.theBoard[i+3][j].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean horizontal(Color r)
    {
        for(int i = 0;  i < MyFrame.theBoard.length;i++)
        {
            for(int j = 0; j < MyFrame.theBoard[0].length-3; j++)
            {
                if(MyFrame.theBoard[i][j].equals(r) && MyFrame.theBoard[i][j+1].equals(r) && MyFrame.theBoard[i][j+2].equals(r) && MyFrame.theBoard[i][j+3].equals(r))
                {
                    return true;

                }
            }
        }
        return false;
    }
public static boolean winner = false;
    public static boolean checkWinner(Color c)
    {

        if(horizontal(c) || vertical(c) || diagonalP(c) || diagonalN(c))
        {
            if(MyPanel.player%2 == 0)
            {
                System.out.println("Yellow won!");
            }
            else
            {
                System.out.println("Red won!");
            }

              winner = true;

        }

        return false;
    }
}
