/**
 * Created by yingyang on 4/13/17.
 */

import java.util.*;
public class wordbreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        backtrack(s, wordDict, 0, "", res);



        return res;


    }

    private static void backtrack(String s, List<String> dict, int start, String last, List<String> res)
    {
        if(start==s.length())
        {
            res.add(last);
            return;
        }

        for(String str : dict)
        {
            int end=start+str.length();
            if(end>s.length()) continue;
            if(s.substring(start, end).equals(str))
            {

                if(last.equals(""))
                {
                    String t=str;
                    backtrack(s, dict, end, t, res);
                }
                else
                {
                    String t = last+" "+str;
                    backtrack(s, dict, end, t, res);
                }
            }
        }

    }

    public static void main(String[] args)
    {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> dict = new ArrayList<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        List<String> res = wordBreak(s, dict);

        for(String str:res)
        {
            System.out.println(s);
        }

    }

}
