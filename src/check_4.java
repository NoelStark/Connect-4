import java.awt.*;

public class check_4 {
    public static boolean checking(int i, int j, int k, int l)
    {

        try
        {

            if(OwnAI.arr[i][j-1] == k && OwnAI.arr[i][j-2] == k && OwnAI.arr[i][j-3] == k && OwnAI.arr[i][j] == 0)
            {
                return true;

            }
        }
        catch(Exception e)
        {

        }
        try{


            if(OwnAI.arr[i][j-1] == k && OwnAI.arr[i][j+1] == k && OwnAI.arr[i][j+2] == k && OwnAI.arr[i][j] == 0)
            {
                return true;
            }
        }
        catch (Exception e)
        {

        }
        try
        {
            if (OwnAI.arr[i][j+1] == k && OwnAI.arr[i][j+2] == k && OwnAI.arr[i][j+3] == k && OwnAI.arr[i][j] == 0) {
                return true;

            }
        }
        catch (Exception e)
        {

        }
        try
        {
            if(OwnAI.arr[i+1][j] == k && OwnAI.arr[i+2][j] == k && OwnAI.arr[i+3][j] == 1 && OwnAI.arr[i][j] == 0)
            {
            return true;
            }
        }
        catch (Exception e)
        {

        }
        try
        {
            if(OwnAI.arr[i+1][j+1] == k && OwnAI.arr[i+2][j+2] == k && OwnAI.arr[i+3][j+3] == k && OwnAI.arr[i][j] == 0)
            {
            return true;
            }
        }
        catch (Exception e)
        {

        }

        try
        {
             if(OwnAI.arr[i-1][j-1] == k && OwnAI.arr[i+1][j+1] == k && OwnAI.arr[i+2][j+2] == k && OwnAI.arr[i][j] == 0)
            {
            return true;
            }
        }
        catch (Exception e)
        {

        }
        try
        {
             if(OwnAI.arr[i+1][j+1] == k && OwnAI.arr[i-1][j-1] == k && OwnAI.arr[i-2][j-2] == k && OwnAI.arr[i][j] == 0)
            {
            return true;
            }
        }
        catch (Exception e)
        {

        }
        try
        {
            if(OwnAI.arr[i-1][j-1] == k && OwnAI.arr[i-2][j-2] == k && OwnAI.arr[i-3][j-3] == k && OwnAI.arr[i][j] == 0)
            {
            return true;
            }
        }
        catch (Exception e)
        {

        }

        try
        {
            if(OwnAI.arr[i+1][j-1] == k && OwnAI.arr[i+2][j-2] == k && OwnAI.arr[i+3][j-3] == k && OwnAI.arr[i][j] == 0)
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
