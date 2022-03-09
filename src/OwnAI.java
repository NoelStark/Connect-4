import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OwnAI {

    public static boolean loopBoard(int k, Color c){

        for(int i = 0; i < 6;i++ )
        {
            for(int j = 0; j < 7; j++)
            {
                if(arr[i][j] == k)
                {
                    MyFrame.theBoard[i][j] = c;
                    return true;
                }
            }
        }
        return false;

    }

    public static int checkfinal(int i, int j)
    {


        if(check_4.checking(i,j,-1,1))
        {
            return -4;
        }
        else if(check_4.checking(i,j,1,-1))
        {
            return 4;
        }
        else if(check_3.checking(i,j, -1,1))
        {
            return -3;
        }
        else if(check_3.checking(i,j, 1,-1))
        {
            return 3;
        }
        else if(check_2.checking(i,j))
        {
            return 2;
        }
        else if(OwnAI.arr[i][j] == -1)
        {
            return -1;
        }
        else{
            return 0;
        }

    }
    public static int[][] arr = new int[6][7];

    public static int[][] arr2 = Arrays.copyOf(arr, arr.length);

    public static void paintBoard()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 7;j++)
            {

                if(MyFrame.theBoard[i][j] == Color.yellow)
                {
                    arr[i][j] = 1;
                }
                else if(MyFrame.theBoard[i][j] == Color.red)
                {
                    arr[i][j] = -1;
                }
                else if(MyFrame.theBoard[i][j] == Color.white)
                {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void board(int player)
    {
        paintBoard();

            for(int j = 0; j < 7; j++)
            {


                if(MyFrame.theBoard[MyPanel.dropP(j)][j] == Color.white)
                {
                    if(player == 1)
                    {
                        MyFrame.theBoard[MyPanel.dropP(j)][j] = Color.yellow;
                    }
                    else if(player == 2)
                    {
                        MyFrame.theBoard[MyPanel.dropP(j)][j] = Color.red;
                    }
                }


                if(arr[MyPanel.dropN(j)][j] == 0)
                {
                    arr[MyPanel.dropN(j)][j] = checkfinal(MyPanel.dropN(j),j);
                }


                if(arr[MyPanel.dropP(j)][j] != 1 && arr[MyPanel.dropP(j)][j] != -1)
                {
                   MyFrame.theBoard[MyPanel.dropP(j)+1][j] = Color.white;
                }


            }
        Color c;
        if(player == 1)
        {
            c = Color.yellow;
        }
        else
        {
            c = Color.red;
        }

        for(int i = 4; i > 1; i--) {

                if(loopBoard(i*-1, c)) break;
                else if(loopBoard(i, c) ) break;
        }
    }
}
