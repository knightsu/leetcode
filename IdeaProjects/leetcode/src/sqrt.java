/**
 * Created by yingyang on 3/31/17.
 */
public class sqrt {

        public static int mySqrt(int x) {
            if(x==0) return 0;
            int lo=1;
            int hi=Integer.MAX_VALUE;
            int mid=lo+(hi-lo)/2;
            while(lo<=hi)
            {
                if(mid>x/mid)
                {
                    hi=mid-1;
                    mid=lo+(hi-lo)/2;
                }
                else if(mid<x/mid)
                {
                    lo=mid+1;
                    mid=lo+(hi-lo)/2;
                }
                else
                    return mid;
            }
            System.out.println(lo<x/lo);
            return lo*lo<x? lo: lo-1;
        }


    public static void main(String[] args)
    {
       // System.out.println(mySqrt(2147483647));
        int[][] matrix = {{}};
        System.out.print(matrix.length);
    }
}
