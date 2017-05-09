/**
 * Created by yingyang on 4/2/17.
 */
public class wordsearch {
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] res = new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col; j++)
            {
                boolean[][] marked = new boolean[row][col];
                res[i][j]=dfs(board, marked, word, 0, i, j);
            }
        }
        boolean flag=false;
        for(int i=0; i< row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(res[i][j])
                {
                    flag=true;
                    break;
                }


            }
        }
        return flag;

    }

    private static boolean dfs(char[][] board, boolean[][] marked, String word, int windex, int row, int col)
    {
        if(row<0||col<0||row==board.length||col==board[row].length||marked[row][col]||board[row][col]!=word.charAt(windex)) return false;
        if(windex==word.length()-1&& board[row][col]==word.charAt(windex) && marked[row][col]==false) return true;

        marked[row][col]=true;
        boolean flag = dfs(board, marked, word, windex+1, row-1, col)||dfs(board, marked, word, windex+1, row+1, col)||dfs(board, marked, word, windex+1, row, col-1)||dfs(board, marked, word, windex+1, row, col+1);

        return flag;

    }

    public static void main(String[] args)
    {
        //char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
       // String s = "ABCESEEEFS";
      //  exist(board, s);

       StringBuilder sb = new StringBuilder("3214515");
        int a=9, b=3;


        sb.insert(2, '(');
        sb.insert(sb.length(),')');
        System.out.print(sb.toString());


    }

}
