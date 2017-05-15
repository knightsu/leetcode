/**
 * Created by yingyang on 4/19/17.
 */
import java.util.*;

public class wordladder2 {
    static Map<String, List<String>> map=new HashMap<>();

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>();
        for(String s:wordList)
        {
            dict.add(s);
        }
        List<List<String>> res = new ArrayList<>();

        int level = findstep(beginWord, endWord, dict);
        if(level==0) return res;


        //find list of strings from set cover

        List<String> ts = new ArrayList<>();
        ts.add(beginWord);
        findres(endWord,res, ts);
        return res;
    }

    private static int findstep(String begin, String end, Set<String> dict)
    {
        if(!dict.contains(end)) return 0;
        Queue<String> sq = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        sq.add(begin);
        level.add(0);

        while(!sq.isEmpty())
        {
            String temp = sq.poll();
            int cur = level.poll();

            List<String> adj = new ArrayList<>();
            for(int i=0;i<temp.length();i++)
            {
                char[] chart = temp.toCharArray();

                for(char c='a';c<='z';c++)
                {
                    chart[i]=c;
                    String str = new String(chart);
                    if(str.equals(end))
                        return cur+1;
                    if(dict.contains(str))
                    {
                        adj.add(str);
                        sq.add(str);
                        dict.remove(str);
                        level.add(cur+1);

                    }
                }
            }
            map.put(temp, adj);

        }
        return 0;
    }



    private static void findres(String end, List<List<String>> res, List<String> ts)
    {
        if(trans(ts.get(ts.size()-1), end))
        {
            List<String> fs = new ArrayList(ts);
            fs.add(end);
            res.add(fs);
            return;
        }

        String s = ts.get(ts.size()-1);
        for(String str: map.get(s))
        {
            ts.add(str);
            findres(end, res, ts);
            ts.remove(str);
        }


    }
    private static boolean trans(String a, String b)
    {
        for(int i=0;i<a.length();i++)
        {
            char[] sa=a.toCharArray();
            for(char c='a';c<='z';c++)
            {
                sa[i]=c;
                String nc = new String(sa);
                if(nc.equals(b))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        List<String> wordlist = new ArrayList<>();
        wordlist.add("hot");
        wordlist.add("dog");
        wordlist.add("dot");
//        wordlist.add("lot");
//        wordlist.add("log");
//        wordlist.add("cog");
        findLadders("hot", "dog", wordlist);
    }

}
