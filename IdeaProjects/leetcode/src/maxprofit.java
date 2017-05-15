/**
 * Created by yingyang on 4/8/17.
 */
public class maxprofit {

    public static int maxProfit(int[] prices) {


        int len = prices.length;
        if(len <= 1) return 0;
        int a, b, c, d;
        d = Math.max(prices[len-1], prices[len-2]);
        c = Math.max(prices[len-1] - prices[len-2], 0);
        b = d;
        a = c;
        for(int i=len-3; i>=0; i--) {
            a = Math.max(b - prices[i], a);
            b = Math.max(prices[i] + c, b);
            c = Math.max(d - prices[i], c);
            d = Math.max(prices[i], d);
        }
        return a;

    }

    public static void main(String[] args)
    {
        int[] prices={7,1,6,5,4,3,8,9,2,1};
        maxProfit(prices);
    }
}
