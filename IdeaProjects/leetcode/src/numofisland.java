/**
 * Created by yingyang on 4/22/17.
 */
import java.util.*;

public class numofisland {

    Map<Integer, String> map = new HashMap<>();
    Map<String, Integer> rmap = new HashMap<>();
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row==0) return 0;
        int col = grid[0].length;
        if(col==0) return 0;
        int onecount=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    onecount++;
                    String s = i+ " "+j;
                    map.put(onecount-1, s);
                    rmap.put(s, onecount-1);
                }
            }
        }
        if(onecount==0) return 0;
        if(onecount==1||onecount==row*col) return 1;
        int[] uf = new int[map.size()];
        int[] sz = new int[map.size()];
        for(int i=0;i<onecount;i++)
        {
            uf[i]=i;
            sz[i]=1;
        }
        for(int i=0;i<map.size();i++)
        {
            String s = map.get(i);
            for(int j=i+1; j<map.size();j++)
            {
                String t=map.get(j);
                if(process(s,t))
                {
                    //union i,j
                    if(!same(i,j,uf))
                    {
                        union(i, j, sz, uf);
                    }
                }
            }
        }
        Set<Integer> f = new HashSet<>();
        for(int i=0; i< map.size(); i++)
        {
            if(!f.contains(root(i, uf)))
            {
                f.add(root(i,uf));
            }
        }
        return f.size();


    }
    private int root(int i,int[] uf)
    {
        while(i!=uf[i])
        {
            uf[i]=uf[uf[i]];
            i=uf[i];

        }
        return i;
    }
    private void union(int i, int j, int[] sz, int[] uf)
    {
        if(sz[i]<sz[j])
        {
            uf[i]=j; sz[j]=sz[j]+sz[i];
        }
        else
        {
            uf[j]=i; sz[i]=sz[i]+sz[j];
        }
    }
    private boolean same(int i, int j, int[] uf)
    {
        if(i==j) return true;
        while(i!=uf[i])
        {
            uf[i]=uf[uf[i]];
            i=uf[i];
        }
        while(j!=uf[j])
        {
            uf[j]=uf[uf[j]];
            j=uf[j];
        }
        if(i==j) return true;
        else return false;

    }

    private boolean process(String s, String t)
    {
        String[] a = s.split(" ");
        String[] b = t.split(" ");
        int[] ia = new int[2];
        int[] ib = new int[2];
        ia[0]=Integer.parseInt(a[0]);
        ia[1]=Integer.parseInt(a[1]);
        ib[0]=Integer.parseInt(b[0]);
        ib[1]=Integer.parseInt(b[1]);
        int r=Math.abs(ia[0]-ib[0])+Math.abs(ia[1]-ib[1]);
        if(r==1) return true;
        else return false;
    }

    public static void main(String[] args)
    {
        numofisland n= new numofisland();
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        n.numIslands(grid);
    }

}
