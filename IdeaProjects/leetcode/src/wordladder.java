import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.*;

/**
 * Created by yingyang on 3/1/17.
 */
public class wordladder {
    public static int solution(String start, String endWord, List<String> wordList)
    {
        if(wordList.size()==0)
        {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> length = new LinkedList<>();

        queue.add(start);
        length.add(1);

        while(!queue.isEmpty())
        {
            String s = queue.poll();
            int curlength = length.poll();
            char[] chararr = s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    chararr[i]=c;
                    String ns = new String(chararr);
                    if(ns.equals(endWord))
                        return curlength+1;
                    else
                    {
                        if(wordList.contains(ns))
                        {
                            System.out.println(ns);
                            queue.add(ns);
                            length.add(curlength+1);
                            wordList.remove(ns);
                        }
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args)
    {

        String start = "hit";
        String end = "cog";
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        int i=solution(start,end,dict);
        System.out.print(i);
    }

}
