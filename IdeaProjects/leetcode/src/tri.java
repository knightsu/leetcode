/**
 * Created by yingyang on 4/7/17.
 */

import java.util.*;
public class tri {

    public static List<List<Integer>> generate(int numRows) {
        int i=1;
        List<List<Integer>> res = new ArrayList<>();

        while(i<=numRows)
        {
            if(res.size()<i)
            {
                List<Integer> t = new ArrayList<>();
                t.add(1);
                res.add(t);
            }
            else
            {
                for(int j=1; j<res.get(i-2).size();j++)
                {
                    res.get(i-1).add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
                }

            }
            if(i>1)
            {
                res.get(i-1).add(1);
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args)
    {
        generate(3);
    }
}
