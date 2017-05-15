/**
 * Created by yingyang on 4/25/17.
 */
public class subarray {
    public static int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int value=0, min=Integer.MAX_VALUE;
        int i=0, j=0;

        while(i<length&&j<=length&&i<=j)
        {
            if(value<s)
            {
                if(j==length) return 0;
                value=value+nums[j];
                j++;
            }
            else
            {
                j--;
                min=Math.min(j-i+1, min);
                value=value-nums[i];
                i++;
                j++;
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }

    public static void main(String[] args)
    {
        int s=7;
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(s,nums);
    }
}
