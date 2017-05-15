/**
 * Created by yingyang on 3/12/17.
 */
public class mergesortarray {
    public void merge(int[] a, int m, int[] b, int n)
    {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(k>=0)
        {
            if(j<0||(i>=0&&a[i]>b[j]))
            {
                a[k--]=a[i--];
            }
            else
            {
                a[k--]=b[j--];
            }
        }


    }
}
