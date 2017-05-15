/**
 * Created by yingyang on 3/23/17.
 */
public class power {
    public static double myPow(double x, int n) {
        double result=1.0;
        if(n==0) return 1.0;
        if(Math.abs(x-0.0)<0.0000001)
            result =0;
        if(Math.abs(x-1.0)<0.0000001)
            result=1;

        if(n<0)
        {
            x=1/x;
            n=-n;

        }
        while(n>0)
        {
            if((n&1)!=0) result=result*x;
            x=x*x;
            n >>=1;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(myPow(2.000000, -2147483648));
    }
}
