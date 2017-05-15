import java.util.HashSet;
import java.util.Set;

/**
 * Created by yingyang on 2/27/17.
 */
public class wordbreak {
    public static boolean iswordbreak(String s, Set<String> dict)
    {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;

        for(int i=0; i<s.length();i++)
        {
            if(!t[i])
                continue;

            for(String a : dict)
            {
                int end = i+a.length();
                if(end > s.length())
                {
                    continue;
                }
                if(s.substring(i,end).equals(a))
                {
                    t[end]=true;
                }
            }
        }
        return t[s.length()];
    }

    public static void main(String[] args)
    {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");


        System.out.println(iswordbreak(s,dict));
    }
}
