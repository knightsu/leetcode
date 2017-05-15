/**
 * Created by yingyang on 9/13/15.
 */
public class lp {
    public String longestPalindrome(String s) {
        int Lo=0;
        int Hi=0;
        int max = 0;
        int len = s.length();

        for(int i=0; i<len-max;i++)       //i: low pointer
        {
            int k=i;            //low iter

            int j = len-1;          // high iter
            int h = j;               //high pointer
            while(j>i)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    h=j;
                    break;
                }
                j--;
            }
            if(s.charAt(i)==s.charAt(h)) {
                while (k < j) {
                    if (s.charAt(k) != s.charAt(j)) {
                        break;
                    }
                    k++;
                    j--;
                }
                if(k==j || s.charAt(k) == s.charAt(j)) {
                    if ((h - i) > max) {
                        max = h - i;
                        Lo = i;
                        Hi = h;
                    }
                }
            }
        }
        return s.substring(Lo,Hi+1);
    }

    public static void main(String[] args)
    {
        String s = "aaabaaaa";
        lp lp = new lp();
        System.out.println(lp.longestPalindrome(s));
    }


}
