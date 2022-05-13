import java.awt.*;
import java.util.*;
import java.util.List;

public class OwnAI {
    public static int[][] arr = new int[6][7]; //Den array som kommer att spegla brädet och beräkna framtida drag

    //Metoden nedan ittererar genom arr[][] och sätter ut markör beroende på värden i array
    private static boolean loopBoard(int k, Color c){

        for(int i = 0; i < 6;i++ )
        {
            for(int j = 0; j < 7; j++)
            {
                if(arr[i][j] == k )
                {
                        MyFrame.theBoard[i][j] = c; //Sätter den specifika platsen till önskad färg
                        return true;
                }
            }
        }
        return false;

    }

    //Kontrollerar om det finns 2,3 eller 4 i rad av någon färg
    private static int checkfinal(int i, int j)
    {


        if(check_4.checking(i,j,-1,1))
        {
            return -4; //Röd 4 i rad
        }
        else if(check_4.checking(i,j,1,-1))
        {
            return 4; //Gul 4 i rad
        }
        else if(check_3.checking(i,j, -1,1))
        {
            return -3; //Röd 3 i rad
        }
        else if(check_3.checking(i,j, 1,-1))
        {
            return 3; //Gul 3 i rad
        }
        else if(check_2.checking(i+1,j)
                || check_2.checking(i,j+1) ||  check_2.checking(i,j-1) ||
                check_2.checking(i-1,j-1) || check_2.checking(i-1,j+1))
        {
            return 2; //Gul 2 i rad
        }

        else if(OwnAI.arr[i][j] == -1)
        {
            return -1; //Röd markör
        }
        else{
            return 0;
        }

    }



    private static void paintBoard() //Filling int[][] arr with numbers depending on colors in Color[][] theBoard
    {
        for(int i = 0; i < 6; i++) //Looping through the 42 different spots where i = Row and j = Column
        {
            for(int j = 0; j < 7;j++)
            {

                if(MyFrame.theBoard[i][j] == Color.yellow)
                {
                    arr[i][j] = 1;//Om det finns en gul markör placerad
                }
                else if(MyFrame.theBoard[i][j] == Color.red)
                {
                    arr[i][j] = -1;//Om det finns en röd markör placerad
                }
                else if(MyFrame.theBoard[i][j] == Color.white)
                {
                    arr[i][j] = 0;//Om platsen är vit
                }
            }
        }
    }

    public static void board(Color c) //The method where the magic happens
    {
        c = Color.yellow;
        paintBoard(); //goes to the method that resets int[][] arr

    for (int j = 0; j < 7; j++) //Loops through every column
    {

        if (MyFrame.theBoard[MyPanel.dropP(j)][j] == Color.white) //If the column isn't full
        {
            MyFrame.theBoard[MyPanel.dropP(j)][j] = c; //Makes the free spot yellow
            arr[MyPanel.dropN(j)][j] = checkfinal(MyPanel.dropN(j), j); //Goes through the method that checks if 2,3 or 4 in a row exists
        }


        if (arr[MyPanel.dropP(j)][j] != 1 && arr[MyPanel.dropP(j)][j] != -1)
        {
            if (MyPanel.dropN(j) == 0) {
                MyFrame.theBoard[MyPanel.dropP(j)][j] = Color.white;//resets the Color[][] back to original state
            } else {
                MyFrame.theBoard[MyPanel.dropP(j) + 1][j] = Color.white; //resets the Color[][] back to original state where +1 makes it reset a row below
            }
        }


    }
        if(c == Color.yellow) c = Color.red;
        else c = Color.yellow;

    for(int i = 4; i > 1; i--) { //This is doing the play

        if(loopBoard(i, c)) break;
        else if(loopBoard(i*-1,c) ) break;
    }


    }
}
