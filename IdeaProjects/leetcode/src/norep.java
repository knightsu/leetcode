/**
 * Created by yingyang on 3/22/17.
 */
public class norep {
    public static int lengthOfLongestSubstring(String s) {
        int max=0;
        int start=0;
        int len =1;
        while(start+len<s.length())
        {
            char c = s.charAt(start+len);

            if(s.substring(start,start+len).indexOf(c)==-1)
            {

                len++;
            }
            else
            {
                String st=s.substring(start,start+len);
                int cut = st.indexOf(c);
                start=cut+1;
                len=1;
            }
            if(len>max) max=len;

        }
        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("abcabcb"));
    }
}
