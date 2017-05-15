import java.util.HashSet;
import java.util.Set;

/**
 * Created by yingyang on 3/15/17.
 */
public class setzero {
    public static void set(int[][] matrix)
    {
        Set<Integer> row_num = new HashSet<>();
        Set<Integer> col_num = new HashSet<>();

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(!row_num.contains(i))
                    {
                        row_num.add(i);
                        sethelper(matrix,i,true);

                    }
                    if(!col_num.contains(j))
                    {
                        col_num.add(j);
                        sethelper(matrix,j,false);
                    }
                }
            }
        }

    }
    private static void sethelper(int[][] matrix, int rowcol, boolean rc)
    {
        //set row all 0
        if(rc)
        {
            int col_tot = matrix[rowcol].length;
            for(int i=0;i<col_tot;i++)
            {
                matrix[rowcol][i]=0;
            }

        }
        else
        {
            int row_tot = matrix.length;
            for(int i=0; i<row_tot;i++)
            {
                matrix[i][rowcol]=0;
            }
        }

    }


}
