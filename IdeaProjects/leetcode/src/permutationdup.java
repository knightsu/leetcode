/**
 * Created by yingyang on 4/2/17.
 */
import java.util.*;
public class permutationdup {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        backtrack(nums,new ArrayList<Integer>(), res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res, List<Integer> index)
    {
        if(temp.size()==nums.length)
        {
            if(res.size()==0)
            {
                res.add(new ArrayList<Integer>(temp));
                return;
            }
            for(List l: res)
            {
                for(int j=0; j<temp.size();j++)
                {
                    Integer a = (Integer)l.get(j);
                    Integer b = (Integer)temp.get(j);
                    if(a.intValue()!=b.intValue())
                    {
                        res.add(new ArrayList<Integer>(temp));
                        return;
                    }


                }
            }

            return;
        }
        for(int i=0;i<nums.length; i++)
        {
            if(index.contains(i)) continue;


            temp.add(nums[i]);
            index.add(i);
            backtrack(nums, temp, res, index);
            temp.remove(temp.size()-1);
            index.remove(index.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[20];
//        permuteUnique(nums);
    }

}
