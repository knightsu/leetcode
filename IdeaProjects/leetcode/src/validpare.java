import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yingyang on 3/12/17.
 */
public class validpare {
    public boolean isvalid(String s)
    {
        char[] chararray = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Stack<Character> temp = new Stack<>();

        for(Character c : chararray)
        {
            if(map.keySet().contains(c))
            {
                temp.push(c);
            }
            else if(map.values().contains(c))
            {
                if(temp.isEmpty()) return false;
                else
                {
                    Character a = temp.pop();
                    if(map.get(a)!=c) return false;

                }
            }
        }

        return temp.isEmpty();
    }

}
