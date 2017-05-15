/**
 * Created by yingyang on 4/24/17.
 */
public class bit {

    public static int hammingWeight(int n) {
        int count=0;
        while(n!=0)
        {
            int a=n>>1;
            if(a*2!=n) count++;
            n=a;
        }

        return count;
    }

    public static void main(String[] args)
    {
        hammingWeight(14);
    }
}
