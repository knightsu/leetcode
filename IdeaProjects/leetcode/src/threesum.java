import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yingyang on 3/12/17.
 */
public class threesum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        cal(nums, res);
        return res;
    }

    private void cal(int[] nums, List<List<Integer>> res)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(i>0&&nums[i]==nums[i-1]) continue;

            int remain = 0-nums[i];
            int a=i+1, b=nums.length-1;
            while(a<b)
            {


                if(nums[a]+nums[b]==remain)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    res.add(temp);
                    while(a<b&&nums[a]==nums[a+1]) a++;
                    while(a<b&&nums[b]==nums[b-1]) b--;
                    a++;b--;
                }
                else if(nums[a]+nums[b]<remain)
                {
                    while(a<b&&nums[a]==nums[a+1]) a++;
                    a++;
                }
                else
                {
                    while(a<b&&nums[b]==nums[b-1]) b--;
                    b--;
                }
            }
        }
    }


    public static void main(String[] args)
    {
        int[] num = new int[]{3,0,-2,-1,1,2};


        List<List<Integer>> results = new ArrayList<>();
        threesum ts = new threesum();
        results=ts.threeSum(num);

        int size = results.size();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.println(results.get(i).get(j));

            }
            System.out.println("\n");
        }
    }


}
