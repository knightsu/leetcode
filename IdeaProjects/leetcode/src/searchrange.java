/**
 * Created by yingyang on 4/11/17.
 */
public class searchrange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
        {
            int[] resa = {-1,-1};
            return resa;
        }
        int lowbound=target-1, upbound=target+1;
        int[] res = {-1,-1};
        int lowindex=BS(nums, lowbound);
        int tarindex=BS(nums, target);
        int upindex = BS(nums, upbound);
        int lowb=-1, upb=-1;

        for(int i=lowindex;i<tarindex;i++)
        {
            if(nums[i]==target)
            {
                lowb=i;break;
            }
        }
        for(int i=upindex;i>tarindex&&i<nums.length;i--)
        {
            if(nums[i]==target)
            {
                upb=i;break;
            }
        }
        if(lowb==-1&&upb==-1)
        {
            if(tarindex<nums.length&&nums[tarindex]==target)
                res[0]=res[1]=tarindex;
        }
        else if(lowb!=-1&&upb==-1)
        {
            res[0]=lowb;res[1]=tarindex;
        }
        else if(lowb==-1&&upb!=-1)
        {
            res[0]=tarindex; res[1]=upb;
        }
        else
        {
            res[0]=lowb;res[1]=upb;
        }


        return res;
    }

    private static int BS(int[] nums, int target)
    {
        int lo=0, hi=nums.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        return lo;
    }

    public static void main(String[] args)
    {
        int[] nums={2,2}; int target =2;
        searchRange(nums,target);
    }
}
