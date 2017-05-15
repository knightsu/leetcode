/**
 * Created by yingyang on 4/21/17.
 */
public class trailingzeros {

    public static int trailingZeroes(int n) {
        int k=getk(n);

        int res=0;
        for(int i=1;i<=k;i++)
        {
            res=res+n/(int)Math.pow(5, i);
        }

        return res;
    }

    private static int getk(int n)
    {
        if(n<5) return 0;
        int base = 5, k=1, did = n;

        while(did>=base)
        {
            base=base*base;
            k=k+k;

        }
        k=k/2;
        base=(int)Math.sqrt(base);
        return k+getk(did/base);

    }

    public static void main(String[] args)
    {
        System.out.print(trailingZeroes(1808548329));
        //System.out.print(Math.pow(5,8388614));
    }
}
