/**
 * Created by yingyang on 4/26/17.
 */
import java.util.*;
public class courses {
    boolean hascycle;
    public  int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Set<Integer>[] adj = new Set[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj[i]=new HashSet<>();
        }
        boolean[] mark = new boolean[numCourses];
        boolean[] detect = new boolean[numCourses];
        Stack<Integer> top = new Stack<>();
        Set<Integer> occur = new HashSet<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            if(adj[prerequisites[i][1]]==null)
            {
                adj[prerequisites[i][1]]=new HashSet<>();
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
            }
            else
            {
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
            }
            if(!occur.contains(prerequisites[i][0]))
            {
                occur.add(prerequisites[i][0]);
            }
        }
        List<Integer> startpt = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(!occur.contains(i))
                startpt.add(i);
        }
        for(int i:startpt)
        {
            dfs(adj, i, mark, detect, top);
        }

        if(hascycle) return res;
        int ord=0;
        while(!top.isEmpty())
        {
            res[ord]=top.pop();
        }
        return res;


    }

    private  void dfs(Set<Integer>[] adj, int start, boolean[] mark, boolean[] detect, Stack<Integer> top)
    {
        mark[start]=true;
        detect[start]=true;
        for(int i:adj[start])
        {
            if(detect[i]) hascycle=true;
            if(!mark[i]) dfs(adj, i, mark, detect, top);
        }
        detect[start]=false;
        top.push(start);

    }

    public static void main(String[] args)
    {
        int[][] pre = new int[][]{{1,0},{2,1},{0,2}};
        int num = 3;
        courses c = new courses();
        c.findOrder(num,pre);
    }

}
