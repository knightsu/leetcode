/**
 * Created by yingyang on 4/28/17.
 */
import java.util.*;
public class wordsearch2 {
    private node root;
    private static class node
    {
        private node[] next = new node[26];
    }
    public boolean get(String s)
    {
        return get(s, 0, root);
    }
    private boolean get(String s, int level, node root)
    {
        if(root==null) return false;
        if(level==s.length()&&root!=null) return true;

        char c = s.charAt(level);
        return get(s, level+1, root.next[c-97]);
    }
    public void add(String s)
    {
        root = add(s, 0, root);
    }
    private node add(String s, int level, node root)
    {
        if(root==null)
        {
            root = new node();

        }
        if(level==s.length()) return root ;

        char c = s.charAt(level);
        root.next[c-97]=add(s, level+1, root.next[c-97]);
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        for(String s : words)
        {
            if(!get(s))
            {
                for(int i=0; i< row; i++)
                {
                    for(int j=0; j<col; j++)
                    {


                        if(board[i][j]==s.charAt(0))
                        {
                            boolean[][] mark = new boolean[row][col];
                            dfs(s, board, i, j, res,0, "", mark);
                        }
                    }
                }
            }
            else
                res.add(s);
        }
        return res;
    }
    private void dfs(String s, char[][] board, int row, int col, List<String> res, int position, String temp, boolean[][] mark)
    {
        if(position==s.length()&& s.equals(temp))
        {
            res.add(temp);
            return;
        }
        if(position==s.length())
        {
            add(temp);
            return;
        }
        int trow=board.length, tcol=board[0].length;
        mark[row][col]=true;
        StringBuilder sb = new StringBuilder(temp);
        sb.append(board[row][col]);

        if(col-1>=0&&!mark[row][col-1]) dfs(s, board, row, col-1, res, position+1, sb.toString(), mark);
        if(col+1<tcol&&!mark[row][col+1]) dfs(s, board, row, col+1, res, position+1, sb.toString(), mark);
        if(row-1>=0&&!mark[row-1][col]) dfs(s, board, row-1, col, res, position+1, sb.toString(), mark);
        if(row+1<trow&&!mark[row+1][col]) dfs(s, board, row+1, col, res, position+1, sb.toString(),mark);

    }

    public static void main(String[] args)
    {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        wordsearch2 ws = new wordsearch2();
        ws.findWords(board, words);
    }

}
