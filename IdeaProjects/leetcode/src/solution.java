import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingyang on 9/4/15.
 */


public class solution {

    public int sumNumbers(TreeNode root) {

        List<String> numString = new ArrayList<String>();
        String sb = "";


        getNum(root, numString, sb);

        int sum = 0;
        for (String s : numString) {
            if (!"".equals(s)) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    public void getNum(TreeNode root, List<String> numString, String sb)
    {
        if(root == null)
        {
            numString.add(sb);

            return;
        }
        String tempstr =  sb + root.val;

        getNum(root.left,numString,tempstr);
        getNum(root.right, numString, tempstr);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left=left;
        root.right=null;

        solution sl = new solution();

        System.out.print(sl.sumNumbers(root));

    }
}
