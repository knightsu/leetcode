/**
 * Created by yingyang on 3/28/17.
 */
import java.util.*;
public class anagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return null;
        Map<String, Integer> com=new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            String a = convert(strs[i]);
            if(com.keySet().contains(a))
            {
                int index=(Integer)com.get(a);
                res.get(index).add(strs[i]);
            }
            else
            {
                int k = com.keySet().size();
                com.put(a,k);
            }
        }
        return res;

    }

    public static String convert (String s)
    {
        int[] t= new int[26];
        for(int i=0;i<s.length();i++)
        {
            t[s.charAt(i)-97]++;
        }
        String res = new String(t, 0,26);
        return res;
    }

    public static void main(String[] args)
    {
        String a ="123 434 4   3  ";
        String[] t = a.split(" ");
        System.out.print(t.length);
    }

}
