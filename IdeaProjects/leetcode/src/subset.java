/**
 * Created by yingyang on 4/2/17.
 */
import java.util.*;
public class subset {
    public static List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            backtrack(res, new ArrayList<Integer>(), nums, i+1, 0);
        }
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int k, int start)
    {
        if(k==0)
        {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(res, temp, nums, k-1, start+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums={1,2,3};
        subsets(nums);
    }
}
