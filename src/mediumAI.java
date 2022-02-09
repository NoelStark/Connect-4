import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class mediumAI{
    public static char[][] board = new char[6][7];
    public static void Board()
    {

        for(int row = 0; row < MyFrame.theBoard.length;row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length;col++)
            {

                if(MyFrame.theBoard[row][col] == Color.yellow)
                {
                    board[row][col] = 1;//Player
                }
                else if(MyFrame.theBoard[row][col] == Color.red)
                {
                    board[row][col] = 2; //AI
                }
                else
                {
                    board[row][col] = 3; //if spot is white
                }
            }
        }
        bestMove();
    }
    public static void bestMove()
    {

        int bestScore = Integer.MIN_VALUE;
        int[] move = {0,0};
        int column = 0;
        int rower = 0;
        for(int row = 0; row < MyFrame.theBoard.length;row++)
        {
            for(int col = 0; col < MyFrame.theBoard[0].length;col++)
            {
                if(board[MyPanel.dropP(row)][col] == 0)
                {
                    if(board[MyPanel.dropP(row)][col] == 2 || board[MyPanel.dropP(row)][col] == 1)
                    {
                        row++;
                    }

                    board[MyPanel.dropP(row)][col] = 2; //Something something here test out.
                    int score = minimax(board,0,false);
                    board[MyPanel.dropP(row)][col] = 0;
                    if(score > bestScore)
                    {
                        bestScore = score;
                        move[0] = row;
                        move[1] = col;
                    }
                }

            }

        }
        board[move[0]][move[1]] = 2;
        MyFrame.theBoard[MyPanel.dropP(move[0])][move[1]] = Color.red;
    }

    public static int minimax(char[][] board, int depth,boolean isMaximizing )
    {
/*
        boolean result_two = CheckWinner.checkWinner(Color.red);
        boolean result_one = CheckWinner.checkWinner(Color.yellow);
        if(result_one)
        {
            return 1;
        }
        else if(result_two)
        {
            return -1;
        }


 */
        if(isMaximizing)
        {
            int bestScore = Integer.MIN_VALUE;
            for(int row = 0; row < board.length; row++)
            {
                for(int col = 0; col < board[0].length; col++)
                {
                    if(board[row][col] != 1 || board[row][col] != 2)
                    {
                        board[MyPanel.dropP(row+1)][col] = 2;
                        int score = minimax(board, depth + 1, false);
                        board[MyPanel.dropP(row+1)][col] = 0;
                        if(score > bestScore)
                        {
                            bestScore = score;
                        }

                    }
                }
            }
            return bestScore;
        }
        else{
            /*
            int bestScore = Integer.MAX_VALUE;
            for(int row = 0; row < board.length; row++)
            {
                for(int col = 0; col < board[0].length; col++)
                {
                    if(board[MyPanel.dropP(row+1)][col] == 0)
                    {
                        board[MyPanel.dropP(row+1)][col] = 1;
                        int score = minimax(board, depth + 1, true);
                        board[MyPanel.dropP(row+1)][col] = 0;
                        if(score < bestScore)
                        {
                            bestScore = score;
                        }

                    }
                }
            }
            return bestScore;
        }

             */
            int bestScore = Integer.MAX_VALUE;
            for(int row = 0; row < board.length; row++)
            {
                for(int col = 0; col < board[0].length; col++)
                {
                    if(board[row][col] != 1 || board[row][col] != 2)
                    {
                        board[MyPanel.dropP(row)][col] = 1;
                        int score = minimax(board, depth + 1, true);
                        board[MyPanel.dropP(row)][col] = 0;
                        if(score < bestScore)
                        {
                            bestScore = score;
                        }

                    }
                }
            }
            return bestScore;
    }


        //public static Color[][] theBoard = new Color[6][7];
        //Check column.
        // If column+1 and row-1 = same color
        // If column+1 and row+1 = same color
        // If column -1 and row -1 = same color
        // If column -1 and row +1 = same color
        // If row-1 = same color
        //Unless if choice = player x gets 3/4 in a row
        /*
        for(int i = 0; i < MyFrame.theBoard.length;i++){
            for(int j = 1; j < MyFrame.theBoard[0].length;j++){
                if(MyFrame.theBoard[i][j+1].equals(Color.red) || MyFrame.theBoard[i][j-1].equals(Color.red)
                || MyFrame.theBoard[i+1][j+1].equals(Color.red))
                {
                    MyFrame.theBoard[i][j] = Color.yellow;
                    if(CheckWinner.checkWinner(Color.yellow))//Checkwinner(theboard[i][j].equals(Color.Yellow)
                    {
                        MyFrame.theBoard[i][j] = Color.white;

                    }
                    else{
                        MyFrame.theBoard[i][j] = Color.red;
                    }
                }
            }
        }

         */



    }

}
