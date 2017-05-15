/**
 * Created by yingyang on 5/3/17.
 */
import java.util.*;
public class duplicate3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0) return false;
        TreeSet<Long> tree = new TreeSet<>();

        for(int i=0;i<nums.length;i++)
        {
            Long floor = tree.floor((long)(nums[i]+t));
            Long ceiling = tree.ceiling((long)(nums[i]-t));
            if((floor!=null&&floor>=nums[i])||(ceiling!=null&&ceiling<=nums[i]))
            {
                return true;
            }
            tree.add((long)(nums[i]));
            if(tree.size()>k)
            {
                tree.remove((long)(nums[i-k]));
            }

        }
        return false;
    }


    public static void main(String[] args)
    {
        int[] a = {-2147483648,-2147483647};
        containsNearbyAlmostDuplicate(a, 3, 3);
    }

}
