import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yingyang on 5/13/17.
 */
public class countdigits {
    Map<Integer, Integer> map = new HashMap<>();
    public int countDigitOne(int n) {
        map.put(0,0);
        int len = 0;
        Stack<Integer> digits = new Stack<>();
        while(n>10)
        {
            len++;
            digits.push(n%10);
            n=n/10;

        }
        digits.push(n);
        countpre(len);

        return count(digits, n);
    }

    private int count(Stack<Integer> digits, int n)
    {
        int tot=0;
        while(!digits.isEmpty())
        {
            int a = digits.pop();
            if(a==0)
            {
                tot=tot;
            }
            else if(a==1)
            {
                tot=tot+map.get(digits.size())+n%((int)Math.pow(10, digits.size())) + 1;
            }
            else
            {
                tot=tot+map.get(digits.size())*a+(int)Math.pow(10, digits.size());
            }
        }
        return tot;
    }

    private void countpre(int len)
    {
        if(len==1)
        {
            map.put(1, 1);
            return;
        }
        if(map.containsKey(len)) return;
        if(!map.containsKey(len-1))
        {
            countpre(len-1);

        }
        map.put(len, 10*map.get(len-1)+(int)Math.pow(10, len-1));

    }

    public static void main(String[] args)
    {
        countdigits cd = new countdigits();
        cd.countDigitOne(10);


    }
}
