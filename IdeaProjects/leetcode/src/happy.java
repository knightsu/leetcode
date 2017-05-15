/**
 * Created by yingyang on 4/24/17.
 */
import java.util.*;
public class happy {

    public static boolean isHappy(int n) {

        Set<Integer> occur = new HashSet<>();
        while(n!=1)
        {
            if(occur.contains(n)) break;
            int a = process(n);
            occur.add(a);
            n=a;
        }
        if(n==1) return true;


        return false;

    }

    public static int process(int n)
    {
        int sum=0;
        while(n>=10)
        {
            sum=sum+(n%10)*(n%10);
            n=n/10;
        }
        sum=sum+n*n;
        return sum;
    }

    public static void main(String[] args)
    {
        isHappy(7);
    }
}
