import java.awt.*;

public class check_3 {
    public static boolean checking()
    {
        for(int i = 0; i < 7;i++)
        {
            for(int j = 0; j <= 6;j++)
            {

                try
                {

                    if(MyFrame.theBoard[i][j-1].equals(Color.yellow) && MyFrame.theBoard[i][j-2].equals(Color.yellow) && MyFrame.theBoard[i][j-3].equals(Color.yellow)
                     && MyFrame.theBoard[i][j].equals(Color.white))
                    {

                        OwnAI.arr[i][j] = 2;
                        return true;

                    }

                    else if(MyFrame.theBoard[i][j+1].equals(Color.yellow) && MyFrame.theBoard[i][j+2].equals(Color.yellow) && MyFrame.theBoard[i][j+3].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 2;
                        return true;

                    }
                    else if(MyFrame.theBoard[i+1][j].equals(Color.yellow) && MyFrame.theBoard[i+2][j].equals(Color.yellow) && MyFrame.theBoard[i+3][j].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 2;
                        return true;
                    }
                    else if(MyFrame.theBoard[i][j].equals(Color.yellow) && MyFrame.theBoard[i+1][j+1].equals(Color.yellow) && MyFrame.theBoard[i+2][j+2].equals(Color.yellow)
                            && MyFrame.theBoard[i][j].equals(Color.white))
                    {
                        OwnAI.arr[i][j] = 2;
                        return true;
                    }
                    else if(OwnAI.arr[i][j] == 1 && MyFrame.theBoard[i][j].equals(Color.red)){

                        OwnAI.arr[i][j] = 0;
                    }
                }
                catch(Exception e)
                {
                    continue;
                }

            }


        }
        return false;
    }
}
