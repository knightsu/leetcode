/**
 * Created by yingyang on 4/1/17.
 */
public class searchmat {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int rownum=searchrow(matrix, target);
        if(matrix[rownum][0]==target) return true;
        return searchtarget(matrix,target, rownum);
    }
    public static int searchrow(int[][] matrix, int target)
    {
        int lo=0;int hi=matrix.length-1;

        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(target<matrix[mid][0])
                hi=mid-1;
            else if(target>matrix[mid][0])
                lo=mid+1;
            else
                return mid;
        }
        return lo-1;
    }
    public static boolean searchtarget(int[][] matrix, int target, int rownum)
    {
        int lo=0; int hi=matrix[rownum].length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(target<matrix[rownum][mid])
                hi=mid-1;
            else if(target>matrix[rownum][mid])
                lo=mid+1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] t = {{}};
        System.out.println(searchMatrix(t, 3));
    }
}
