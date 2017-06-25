/**
 * Created by yingyang on 6/24/17.
 */
public class GCD {
    public int genGCD(int a, int b)
    {
        if(b==0) return a;
        return a%b==0? b :genGCD(b, a%b);
    }
}
