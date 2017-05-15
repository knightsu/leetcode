/**
 * Created by yingyang on 4/18/17.
 */
public class comver {

    public static int compareVersion(String version1, String version2) {

        int[] iv1 = new int[2];
        int[] iv2 = new int[2];

        int i1=version1.indexOf(".");
        int i2=version2.indexOf(".");

        if(i1==-1)
        {
            iv1[0]=Integer.parseInt(version1);
            iv1[1]=0;
        }
        if(i2==-1)
        {
            iv2[0]=Integer.parseInt(version2);
            iv2[1]=0;
        }

        if(i1!=-1&&i2!=-1)
        {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");


            iv1[0]=Integer.parseInt(v1[0]);
            iv1[1] = Integer.parseInt(v1[1]);

            iv2[0]=Integer.parseInt(v2[0]);
            iv2[1]=Integer.parseInt(v2[1]);
        }

        if(iv1[0]>iv2[0]) return 1;
        else if(iv1[0]<iv2[0]) return -1;
        else
        {
            if(iv1[1]>iv2[1]) return 1;
            else if(iv1[1]<iv2[1]) return -1;
            else
                return 0;
        }
    }

    public static void main(String[] args)
    {
        compareVersion("1","1.1");

    }
}
