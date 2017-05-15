/**
 * Created by yingyang on 3/27/17.
 */

import java.util.*;
public class comsum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return get(candidates, target);

    }
    public static List<List<Integer>> get(int[] candidates, int diff)
    {
        if(diff<0)  return null;
        if(diff==0)
        {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(0);
            result.add(l);
            return result;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<candidates.length;i++)
        {
            List<List<Integer>> temp = get(candidates, diff-candidates[i]);
            if(temp==null) continue;
            for(List<Integer> l:temp)
            {
                l.add(candidates[i]);
                if(!l.contains(-1))
                {
                    l.remove(0);
                    result.add(l);
                }

            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        combinationSum(new int[]{2,3,6,7}, 7);
    }
}
