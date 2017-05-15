/**
 * Created by yingyang on 4/14/17.
 */
public class painthouse {
    public static int mincost(int[][] cost)
    {
        int house = cost.length;

        for(int i=1;i<house;i++)
        {
            cost[i][0]=cost[i][0]+Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1]=cost[i][1]+Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2]=cost[i][2]+Math.min(cost[i-1][1], cost[i-1][0]);
        }

        return Math.min(cost[house-1][0], Math.min(cost[house-1][1], cost[house-1][2]));
    }
}
