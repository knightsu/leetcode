import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingyang on 5/13/17.
 */
public class length {
    Map<Integer, Integer> map = new HashMap<>();
    public void countpre(int len)
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
}
