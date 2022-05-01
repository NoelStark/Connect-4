import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CheckWinner{



    public static boolean diagonalP(Color r)
    {
        for(int i = 0;  i < MyFrame.theBoard.length-3;i++)
        {
            for(int j = 0; j < MyFrame.theBoard[0].length-3; j++)
            {

                if(MyFrame.theBoard[i][j].equals(r) && MyFrame.theBoard[i+1][j+1].equals(r) && MyFrame.theBoard[i+2][j+2].equals(r) && MyFrame.theBoard[i+3][j+3].equals(r))
                {
                    MyFrame.theBoard[i][j] = Color.green;
                    MyFrame.theBoard[i+1][j+1] = Color.green;
                    MyFrame.theBoard[i+2][j+2] = Color.green;
                    MyFrame.theBoard[i+3][j+3] = Color.green;
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
                    MyFrame.theBoard[i][j] = Color.green;
                    MyFrame.theBoard[i+1][j-1] = Color.green;
                    MyFrame.theBoard[i+2][j-2] = Color.green;
                    MyFrame.theBoard[i+3][j-3] = Color.green;
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
                    MyFrame.theBoard[i][j] = Color.green;
                    MyFrame.theBoard[i+1][j] = Color.green;
                    MyFrame.theBoard[i+2][j] = Color.green;
                    MyFrame.theBoard[i+3][j] = Color.green;
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
                    MyFrame.theBoard[i][j] = Color.green;
                    MyFrame.theBoard[i][j+1] = Color.green;
                    MyFrame.theBoard[i][j+2] = Color.green;
                    MyFrame.theBoard[i][j+3] = Color.green;
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
            if(MyPanel.player%2 == 0 && c == Color.yellow)
            {
                System.out.println("Yellow won!");
            }
            else
            {
                System.out.println("Red won!");
            }


            winner = true;

        }

        if(Arrays.stream(MyFrame.theBoard).flatMap(Arrays::stream).noneMatch(value -> value == Color.white)) {
            System.out.println("Draw!");
            winner = true;
            return true;
        }



        return false;
    }
}
