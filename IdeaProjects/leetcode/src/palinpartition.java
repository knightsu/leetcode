/**
 * Created by yingyang on 4/30/17.
 */
import java.util.*;

public class palinpartition {
    Map<String, List<List<String>>> map = new HashMap<>();
    public List<List<String>> partition(String s) {
        return backtrack(s);
    }

    private List<List<String>> backtrack(String s)
    {
        if(map.containsKey(s)) return map.get(s);
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(s.equals(""))
        {
            temp.add("");
            res.add(temp);
            return res;
        }

        for(int i=1; i<= s.length(); i++)
        {
            if(ispalidrone(s.substring(0, i)))
            {
                List<List<String>> follow = backtrack(s.substring(i));
                for(List l : follow)
                {
                    l.add(s.substring(0, i));
                }
            }
        }
        map.put(s, res);
        return res;

    }


    private boolean ispalidrone(String s)
    {

        for(int i=s.length()/2-1;i>=0;i--)
        {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;


    }

    public static void main(String[] args)
    {
        palinpartition pl = new palinpartition();
        pl.partition("aab");



    }
}
