/**
 * Created by yingyang on 3/21/17.
 */
import java.util.*;
public class reint {
    public static int reverse(int x) {
        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) return 0;

        int abx= Math.abs(x);

        int revers = helper(abx);

        if(x<0)
            return 0-revers;
        else
            return x;

    }
    public static int helper(int x)
    {
        if(x<10) return x;
        List<Integer> temp = new ArrayList<>();
        while(x>10)
        {
            temp.add(x%10);
            x=x/10;
        }
        temp.add(x);
        StringBuilder sb = new StringBuilder();
        for(Integer i : temp)
        {
            sb.append(i.toString());
        }
        return  Integer.parseInt(sb.toString());
    }

    public static void main(String[] args)
    {
        reverse(123);
    }
}
