import java.awt.*;

public class CheckWinnerV2 {


    public static boolean Horizontal_2(Color r)
    {
        for(int row = 0; row < MyFrame.theBoard.length; row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length-3; col++)
            {
                if(MyFrame.theBoard[row][col].equals(r) && MyFrame.theBoard[row][col+1].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Vertical_2(Color r)
    {
        for(int row = 0; row < MyFrame.theBoard.length-3; row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length; col++)
            {
                if(MyFrame.theBoard[row][col].equals(r) && MyFrame.theBoard[row+1][col].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean diagonalP_2(Color r)
    {
        for(int row = 0; row < MyFrame.theBoard.length-3; row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length-3; col++)
            {
                if(MyFrame.theBoard[row][col].equals(r) && MyFrame.theBoard[row+1][col+1].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean diagonalN_2(Color r)
    {
        for(int row = 0; row < MyFrame.theBoard.length-3; row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length; col++)
            {
                if(MyFrame.theBoard[row][col].equals(r) && MyFrame.theBoard[row+1][col-1].equals(r))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinner(Color r)
    {
        boolean winner = false;
        if(Vertical_2(r) || Horizontal_2(r) || diagonalP_2(r) || diagonalN_2(r))
        {
            winner = true;
        }

        return winner;
    }

    public static void test()
    {




    }

    /*
     int x = rnd.nextInt(0,6);
        int clickRow;
        int clickCol = x;
        clickRow = MyPanel.dropP(x);

        MyFrame.theBoard[clickRow][x] = Color.red;
     */


}
