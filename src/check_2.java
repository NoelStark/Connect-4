import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class check_2 {

    public static boolean checking(int x1, int y1)
    {
        try
        {
            if(OwnAI.arr[x1][y1] == 1)
            {
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return false;
    }
}