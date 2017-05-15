import java.util.HashSet;
import java.util.Set;

/**
 * Created by yingyang on 9/11/15.
 */
public class ls {


    public int lengthOfLongestSubstring(String s) {
        Set<Character> container = new HashSet<Character>();
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length();i++)
        {
            Character temp = new Character(s.charAt(i));
            if(!container.contains(temp))
            {
                container.add(temp);
            }
            else
            {
                int length = i-start+1;
                start=i;
                container.clear();

                if(length>max)
                {
                    max = length;
                }
            }
        }

        int length = s.length()-start;
        if(length>max)
        {
            max = length;
        }

        return max;
    }

    public static void main(String[] args)
    {
        ls ls = new ls();
        ls.lengthOfLongestSubstring("abacagafdasdf");
    }
}
