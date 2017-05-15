/**
 * Created by yingyang on 4/23/17.
 */
public class binary {

    public static int rangeBitwiseAnd(int m, int n) {

        String ms = Integer.toBinaryString(m);
        String ns = Integer.toBinaryString(n);
        int mlen = ms.length();
        int nlen = ns.length();
        if(nlen>mlen)
        {
            return 0;
        }
        else
        {
            int dif = n-m;
            String ds = Integer.toBinaryString(dif);
            int dlen = ds.length();
            int man = m&n;
            String mans = Integer.toBinaryString(man);
            char[] manc = mans.toCharArray();
            int manlen = manc.length;
            for(int i=manlen-1;i>manlen-dlen;i--)
            {
                manc[i]='0';
            }
            String nfs = new String(manc);
            return Integer.parseInt(nfs,2);
        }


    }

    public static void main(String[] args)
    {
        rangeBitwiseAnd(11,14);
    }

}
