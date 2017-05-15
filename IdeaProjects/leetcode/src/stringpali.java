/**
 * Created by yingyang on 4/8/17.
 */
public class stringpali {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
            {
                sb.append(s.charAt(i));
            }
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
            {
                char c=(char)(s.charAt(i)+32);
                sb.append(c);
            }
        }

        String ns = sb.toString();

        if(ns.length()%2==0)
        {
            for(int i=ns.length()/2-1;i>=0;i--)
            {
                if(s.charAt(i)!=s.charAt(ns.length()-1-i))
                    return false;
            }
        }
        else
        {
            int mid= ns.length()/2;
            for(int i=mid-1;i>=0;i--)
            {
                if(s.charAt(i)!=s.charAt(ns.length()-1-i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s="aA";
        System.out.print(isPalindrome(s));
    }
}
