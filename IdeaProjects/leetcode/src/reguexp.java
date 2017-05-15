/**
 * Created by yingyang on 3/14/17.
 */
public class reguexp {
    public static boolean ismatch(String a, String b)
    {
        int alen = a.length();
        int blen = b.length();

        int i=0; int j=0;
        while(i<alen && j<blen)
        {
            if(a.charAt(i)==b.charAt(j)&&a.charAt(i)!='*'&&b.charAt(j)!='*')
            {
                i++; j++;
            }
            else if(a.charAt(i)=='.' || b.charAt(j)=='.')
            {
                i++; j++;
            }
            else if(a.charAt(i)=='*' || b.charAt(j)=='*')
            {
                char apre = a.charAt(i-1);
                char bpre = a.charAt(j-1);
                //find the first char which is diff than pre

                {

                }
            }
        }

        return true;
    }

}
