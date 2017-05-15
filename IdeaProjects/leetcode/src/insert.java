/**
 * Created by yingyang on 3/26/17.
 */
public class insert {
    public static int searchInsert(int[] nums, int target) {
        int index=BS(nums,target, 0, nums.length);
        return index;

    }
    public static int BS(int[] nums, int target, int start, int end)
    {
        if(start>=end) return start;
        int mid=start+(end-start)/2;
        if(target>nums[mid]) return BS(nums,target,mid+1, end);
        else if(target<nums[mid]) return BS(nums, target, start, mid-1);
        else return mid;
    }

    public static void main(String[] args)
    {
        int[] nums={1,3};
        System.out.println(searchInsert(nums, 2));
    }
}
