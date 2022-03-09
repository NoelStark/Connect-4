import java.awt.*;

public class check_2 {
    public static boolean checking(int i, int j)
    {



                try
                {
                    if(OwnAI.arr[i][j+1] == 1 && OwnAI.arr[i][j] != -1)
                    {

                        return true;

                    }
                }
                catch(Exception e)
                {

                }
                try{

                    if(OwnAI.arr[i+1][j] == 1 && OwnAI.arr[i][j] != -1)
                    {
                        return true;
                    }
                }
                catch(Exception e)
                {
                }
                try{
                    if(OwnAI.arr[i][j-1] == 1  && OwnAI.arr[i][j] != -1)
                    {
                        return true;

                    }
                }
                catch(Exception e)
                {
                }

                try
                {
                    if(OwnAI.arr[i+1][j+1] == 1 && OwnAI.arr[i][j] != -1)
                    {
                        return true;
                    }
                }
                catch (Exception e)
                {

                }
                try
                {
                    if(OwnAI.arr[i-1][j-1] == 1 && OwnAI.arr[i][j] != -1)
                    {
                    return true;
                    }
                }
                catch (Exception e)
                {

                }



        return false;


    }
}
