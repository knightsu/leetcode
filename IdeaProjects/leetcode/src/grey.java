/**
 * Created by yingyang on 4/4/17.
 */
import java.util.*;
public class grey {
    public static List<Integer> grayCode(int n) {
        List<String> res = new ArrayList<>();
        List<Integer> fres = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sb.append('0');
        }
        res.add(sb.toString());
        fres.add(0);
        int len=(int)Math.pow(2, n);
        helper(n, res, fres, len);
        return fres;

    }
    private static int convert(String s)
    {
        int t=0, len=s.length();
        for(int i=len;i>0;i--)
        {
            if(s.charAt(i-1)=='1')
            {
                t=t+(int)Math.pow(2, len-i);
            }
            else
                continue;
        }
        return t;
    }
    public static void helper(int n, List<String> temp,List<Integer> resi, int len)
    {
        while(len>0)
        {
            String s = temp.get(temp.size()-1);
            char[] sarr = s.toCharArray();
            for(int i=n;i>0;i--)
            {
                if(sarr[i-1]=='0')
                {
                    sarr[i-1]='1';
                    String ts = new String(sarr);
                    if(!temp.contains(ts))
                    {
                        temp.add(ts);
                        resi.add(convert(ts));
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    sarr[i-1]='0';
                    String ts = new String(sarr);
                    if(!temp.contains(ts))
                    {
                        temp.add(ts);
                        resi.add(convert(ts));
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            len--;
        }
    }

    public static void main(String[] args)
    {
        grayCode(4);
    }

}
