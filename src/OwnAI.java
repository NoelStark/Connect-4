import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OwnAI {

    /*
     int x = rnd.nextInt(0,6);
        int clickRow;
        int clickCol = x;
        clickRow = MyPanel.dropP(x);

        MyFrame.theBoard[clickRow][x] = Color.red;
     */
    public static int[][] arr = new int[6][7];
    public static void board()
    {
        //int j = 0;

        int clickRow;
        check_2.checking();
        check_3.checking();
        int count = 0;
        outerloop:

        for(int k = 0; k < 6; k++)
        {
            for(int col = 0; col < 7;col++)
            {
                if(arr[k][col] == 2 && MyFrame.theBoard[k][col-1] != Color.white)
                {

                        MyFrame.theBoard[MyPanel.dropP(col)][col] = Color.red;

                        count++;
                        arr = new int[6][7];
                        break outerloop;
                }
                else if(arr[k][col] == 1)
                {
                    MyFrame.theBoard[MyPanel.dropP(col)][col] = Color.red;
                    MyFrame.theBoard[MyPanel.dropP(col-1)][col] = Color.green;
                    check_3.checking();
                    count++;
                    arr = new int[6][7];
                    break outerloop;
                }

            }
        }
        /*
        if(count == 0)
        {
            SimpleAI.simpleAI();
        }

         */
    }
}
