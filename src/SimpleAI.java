import java.awt.*;
import java.util.Random;

public class SimpleAI {
    public static void simpleAI()
    {
        Random rnd = new Random();

        int x = rnd.nextInt(0,6);
        int clickRow;
        clickRow = MyPanel.dropP(x);

        MyFrame.theBoard[clickRow][x] = Color.red;
    }

}
