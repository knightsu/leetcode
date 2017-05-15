import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingyang on 4/15/17.
 */
public class searchrote {
    public static int findMin(int[] nums) {
        int end=0, start=nums.length-1;
        if(nums[end]<nums[start]) return nums[end];

        while(end<start)
        {
            int mid=end+(start-end)/2;
            if(nums[mid]>=nums[end])
            {
                end=mid+1;
            }
            else
            {
                start=mid;

            }

            if(mid-1>=0&&mid+1<nums.length&&nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1])
            {
                return nums[mid];
            }
        }
        return nums[end];
    }

    public static void main(String[] args)
    {
//        int[] nums = {4,5,6,1,2,3};
//        findMin(nums);
        List<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        int a=test.remove(3);
        test.add(4);

    }
}
