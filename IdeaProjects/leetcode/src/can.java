/**
 * Created by yingyang on 5/26/17.
 */
public class can {
    public int candy(int[] ratings) {
        int start = 0;
        int[] mincan = new int[ratings.length];
        for(int i=1; i< ratings.length-1; i++)
        {
            if(ratings[i]<ratings[i-1] && ratings[i]<ratings[i+1]) // vally
            {
                cal(ratings, mincan, start, i-1, false);
                start = i;
            }
            if(ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1])  //peek
            {
                cal(ratings, mincan, start, i, true);
                start=i+1;
            }

        }
        int sum=0;
        for(int i=0; i< mincan.length; i++)
        {
            sum = sum+mincan[i];
        }
        return sum;
    }
    private void cal(int[] ratings, int[] mincan, int start, int end, boolean flag)
    {
        if(flag)  //ascend
        {
            for(int i=start; i<=end; i++)
            {
                mincan[i]=i-start+1;
            }
        }
        else
        {
            for(int i=end; i>=start; i--)
            {
                mincan[i]=end-i+2;
            }
        }
        //check peek value violation
        if(start!=0 && ratings[start]<ratings[start-1] && mincan[start]>mincan[start-1])
        {
            mincan[start-1]=mincan[start]+1;
        }
    }
}
