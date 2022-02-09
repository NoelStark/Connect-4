import java.awt.*;

public class check_2 {
    public static void checking()
    {

        for(int i = 0; i < 6;i++)
        {
            for(int j = 0; j <=6;j++)
            {

                try
                {

                    if(MyFrame.theBoard[i][j+1].equals(Color.yellow) && MyFrame.theBoard[i][j+2].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 1;

                    }
                    else if(MyFrame.theBoard[i][j-1].equals(Color.yellow) && MyFrame.theBoard[i][j-2].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white)){
                        OwnAI.arr[i][j] = 1;

                    }
                    else if(MyFrame.theBoard[i+1][j].equals(Color.yellow) && MyFrame.theBoard[i+2][j].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 1;
                    }
                    else if(MyFrame.theBoard[i][j].equals(Color.yellow) && MyFrame.theBoard[i+1][j+1].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 1;
                    }
                }
                catch(Exception e)
                {
                    continue;
                }

            }


        }
    }
}
