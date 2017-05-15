/**
 * Created by yingyang on 5/5/17.
 */
public class findnum {
    public static int countNodes(TreeNode root) {
        int numnode=0;
        int total = 0;
        if(root==null)
        {
            return 0;
        }
        int lh=0, rh=0;
        //get left height and right height
        TreeNode iter = root.left;
        while(iter!=null)
        {
            lh++;
            iter=iter.left;
        }
        iter=root.right;
        while(iter!=null)
        {
            rh++;
            iter=iter.right;
        }
        if(lh==rh) return (int)Math.pow(2, lh+1)-1;

        //using binary search check leaf node existance
        int num=(int)Math.pow(2, lh);
        iter=root;
        int ih=0;
        while(iter!=null)
        {
            int a = findsuccessor(iter)+ih;

            if(a<lh)
            {
                num=num-(int)Math.pow(2, a);
                iter=iter.left;
            }
            else
            {
                iter=iter.right;
            }
            ih++;
        }

        int tot = (int)Math.pow(2, lh)-1+num;



        return tot;
    }

    private static int findsuccessor(TreeNode root)
    {
        int count=0;
        TreeNode iter = root.right;
        while(iter!=null)
        {
            count++;
            iter=iter.left;
        }
        return count;
    }

    public static void main(String[] args)
    {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        TreeNode t16 = new TreeNode(16);
        TreeNode t17 = new TreeNode(17);
        TreeNode t18 = new TreeNode(18);
        TreeNode t19 = new TreeNode(19);
        TreeNode t20 = new TreeNode(20);
        TreeNode t21 = new TreeNode(21);
        TreeNode t22 = new TreeNode(22);
        t1.left=t2; t1.right=t3;
        t2.left=t4; t2.right=t5;
        t3.left=t6; t3.right=t7;
        t4.left=t8; t4.right=t9;
        t5.left=t10; t5.right=t11;
        t6.left=t12; t6.right=t13;
        t7.left=t14; t7.right=t15;
        t8.left=t16; t8.right=t17;
        t9.left=t18; t9.right=t19;
        t10.left=t20; t10.right=t21;
        t11.left=t22;
        countNodes(t1);
    }
}
