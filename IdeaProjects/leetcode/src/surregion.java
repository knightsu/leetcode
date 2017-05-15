/**
 * Created by yingyang on 4/9/17.
 */
import java.util.*;
public class surregion {
    public static void solve(char[][] board) {

        int trow=board.length;
        int tcol=board[0].length;
        for(int i=0;i<trow;i++)
        {
            if(board[i][0]=='O')
            {
                find(board, i,0);
            }
            if(board[i][tcol-1]=='O')
            {
                find(board, i, tcol-1);
            }
        }
        for(int j=0;j<tcol;j++)
        {
            if(board[0][j]=='O')
            {
                find(board, 0, j);
            }
            if(board[trow-1][j]=='O')
            {
                find(board, trow, j);
            }
        }

        for(int i=0;i<trow;i++)
        {
            for(int j=0;j<tcol;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if(board[i][j]=='t')
                {
                    board[i][j]='O';
                }
            }
        }


    }
    //from edge find 'o' area in middle
    private static void find(char[][] board, int row, int col)
    {
        int trow=board.length;
        int tcol=board[0].length;
        Queue<Integer> rowq= new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        rowq.add(row);
        colq.add(col);


        while(!rowq.isEmpty()&&!colq.isEmpty())
        {
            int nrow=rowq.poll();
            int ncol=colq.poll();

            if(ncol-1>=0&&board[nrow][ncol-1]=='O')
            {
                board[nrow][ncol-1]='t';
                rowq.add(nrow);
                colq.add(ncol-1);
            }
            if(ncol+1<tcol&&board[nrow][ncol+1]=='O')
            {
                board[nrow][ncol+1]='t';
                rowq.add(nrow);
                colq.add(ncol+1);
            }
            if(nrow-1>=0&&board[nrow-1][ncol]=='O')
            {
                board[nrow-1][ncol]='t';
                rowq.add(nrow-1);
                colq.add(ncol);
            }
            if(nrow+1<trow&&board[nrow+1][ncol]=='O')
            {
                board[nrow+1][ncol]='t';
                rowq.add(nrow+1);
                colq.add(ncol);
            }

        }
    }

    public static void main(String[] args)
    {
        //char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //solve(board);

        Map<Integer, String> a = new HashMap<>();

        a.put(2, "dsaf");


    }
}
