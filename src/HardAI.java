import java.awt.*;
import java.util.*;
import java.util.List;

public class HardAI {
    public static double loopCopiedboard(){ //Gets a value based on current board state
        double value = 0;
        int count = 0;
        for(int i = 0; i < 6;i++ )
        {
            for(int j = 0; j < 7; j++)
            {
                if(arr[i][j] != 1 && arr[i][j] != -1 && arr[i][j] != 0)
                {
                    value += arr[i][j];
                    count++;
                }
            }
        }
        value = value/count;
        return value;

    }


    public static boolean loopBoard(int k, Color c){

        for(int i = 0; i < 6;i++ )
        {
            for(int j = 0; j < 7; j++)
            {
                if(Main.copiedArray[i][j] == k )
                {
                    MyFrame.theBoard[i][j] = c; //First time is the fake, second the real
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
        else if(check_2.checking(i,j) || check_2.checking(i-1,j) || check_2.checking(i+1,j)
                || check_2.checking(i,j+1) ||  check_2.checking(i,j-1) ||
                check_2.checking(i-1,j-1) || check_2.checking(i-1,j+1))
        {
            return 2;
        }
/*
        else if(check_2.checking(i,j))
        {
            return 2;
        }

 */
        else if(OwnAI.arr[i][j] == -1)
        {
            return -1;
        }
        else{
            return 0;
        }

    }
    public static int[][] arr = new int[6][7];
    public static double bestScore = 0;



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
        Color c = Color.red;
        bestScore = 0;
        loop:
        for(int p = 0; p <= 2; p++)
        {
            paintBoard();

            for(int j = 0; j < 7; j++)
            {

                if(MyFrame.theBoard[MyPanel.dropP(j)][j] == Color.white)
                {
                    MyFrame.theBoard[MyPanel.dropP(j)][j] = Color.yellow;
                    arr[MyPanel.dropN(j)][j] = checkfinal(MyPanel.dropN(j),j);
                }


                if(arr[MyPanel.dropP(j)][j] != 1 && arr[MyPanel.dropP(j)][j] != -1)
                {
                    if(MyPanel.dropN(j) == 0)
                    {
                        MyFrame.theBoard[MyPanel.dropP(j)][j] = Color.white;
                    }
                    else
                    {
                        MyFrame.theBoard[MyPanel.dropP(j)+1][j] = Color.white;
                    }
                }


            }




            if(!MyPanel.alreadyExecuted)
            {
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 7;j++)
                    {
                        Main.copiedArray[i][j] = arr[i][j];
                        Main.copiedBoard[i][j] = MyFrame.theBoard[i][j];
                    }
                }
                MyPanel.alreadyExecuted = true;
            }

            for(int i = 4; i > 1; i--) { //The fake play

                if(loopBoard(i*-1, c)) break;
                else if(loopBoard(i, c) ) break;

            }
            if(c == Color.red)
            {
                c = Color.yellow;
            }
            else
            {
                c = Color.red;
            }


            double score = loopCopiedboard();
            if(Arrays.stream(arr).flatMapToInt(Arrays::stream).noneMatch(value -> value == 4 || value == -4))
            {


                if(score < bestScore) //Gets max score based on yellow moves
                {
                    for(int i = 0; i < 6;i++)
                    {
                        for(int j = 0; j < 7; j++)
                        {
                            Main.tempCopy[i][j] = arr[i][j];
                        }
                    }
                    outerloop:
                    for(int a = 0; a < 6; a++) //Resetting the copied array
                    {
                        for(int b = 0; b < 7; b++)
                        {
                            if(Main.copiedArray[a][b] != 0 && Main.copiedArray[a][b] != 1 && Main.copiedArray[a][b] != -1)
                            {
                                Main.copiedArray[a][b] = 0;
                                break outerloop;
                            }
                        }
                    }
                    bestScore = score;
                }
            }
            else if(Arrays.stream(arr).flatMapToInt(Arrays::stream).anyMatch(value -> value == 4))
            {
                break loop;
            }
            else if(Arrays.stream(arr).flatMapToInt(Arrays::stream).anyMatch(value -> value == -4))
            {
                break loop;
            }




            for(int i = 4; i > 1; i--) { //The fake play

                if(loopBoard(i*-1, c)) break;
                else if(loopBoard(i, c) ) break;

            }

        }
        for(int k = 0; k < 6; k++)
        {
            for(int l = 0; l < 7; l++)
            {
                MyFrame.theBoard[k][l] = Main.copiedBoard[k][l];

            }
        }
        for(int i = 4; i > 1; i--) { //This is doing the actual play

            if(loopBoard(i, Color.red)) break;
            else if(loopBoard(i*-1, Color.red) ) break;

        }

    }
}
