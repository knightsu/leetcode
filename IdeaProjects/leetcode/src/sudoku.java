/**
 * Created by yingyang on 3/26/17.
 */
import java.util.*;
public class sudoku {
    public static boolean isValidSudoku(char[][] board) {

        return validrow(board)&&validcol(board)&&validsub(board);

    }
    public static boolean validrow(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            Set<Character> temp=new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.') continue;
                if(board[i][j]<'1'||board[i][j]>'9')
                {
                    return false;
                }
                else
                {
                    if(temp.contains(board[i][j])) return false;
                    else temp.add(board[i][j]);
                }
            }
        }
        return true;
    }
    public static boolean validcol(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            Set<Character> temp=new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[j][i]=='.') continue;
                if(board[j][i]<'1'||board[j][i]>'9')
                {
                    return false;
                }
                else
                {
                    if(temp.contains(board[j][i])) return false;
                    else temp.add(board[j][i]);
                }
            }
        }
        return true;
    }
    public static boolean validsub(char[][] board)
    {
        for(int i=0;i+3<9;i+=3)
        {
            for(int j=0;j+3<9;j+=3)
            {
                Set<Character> temp = new HashSet<>();
                for(int k=i;k<i+3;k++)
                {
                    for(int l=j;l<j+3;l++)
                    {
                        if(board[k][l]=='.') continue;
                        if(board[k][l]<'1'||board[k][l]>'9')
                        {

                            return false;
                        }
                        else
                        {
                            if(temp.contains(board[k][l]))
                            {
                                System.out.println(k);
                                System.out.println(l);
                                System.out.println(i);
                                System.out.println(j);
                                return false;
                            }
                            else temp.add(board[k][l]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'9','3','.','.','2','.','4','.','.'},
                {'.','.','7','.','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','4','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','.'},
                {'.','.','.','.','.','5','2','.','.'},
        };
//        System.out.print(false&&true&&false);
        System.out.println(validrow(board));
        System.out.println(validcol(board));
        System.out.println(validsub(board));
//        System.out.print(isValidSudoku(board));
    }

}
