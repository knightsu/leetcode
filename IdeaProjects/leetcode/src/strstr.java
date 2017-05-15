/**
 * Created by yingyang on 3/14/17.
 */
public class strstr {
    public static String str(String haystack, String needle)
    {
        int haylen = haystack.length();
        int neelen = needle.length();

        if(haylen==0 && neelen==0) return "";
        if(neelen==0)  return haystack;
        int j;
        for(int i=0; i<haylen-neelen+1;i++)
        {
            for(j=0; j<neelen; j++)
            {
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(j==neelen)
            {
                return haystack.substring(i);
            }
        }
        return null;
    }


    public static void main(String[] args)
    {
        System.out.println(str("abcdefg", "def"));
    }
}
