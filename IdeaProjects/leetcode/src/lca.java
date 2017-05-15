/**
 * Created by yingyang on 9/5/15.
 */
public class lca {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==null)
        {
            return null;
        }


        if(root.left!=null)
        {
            if(isAncestor(root.left,p)&&isAncestor(root.left,q))
            {
                return lowestCommonAncestor(root.left,p,q);
            }
        }
        if(root.right!=null)
        {
            if(isAncestor(root.right, q)&&isAncestor(root.right, p))
            {
                return lowestCommonAncestor(root.right, p, q);
            }
        }

        return root;
    }

    private boolean isAncestor(TreeNode root, TreeNode p)
    {
        if(root == null)
        {
            return false;
        }
        if(root.val==p.val)
        {
            return true;
        }
        isAncestor(root.left,p);
        isAncestor(root.right, p);
        return false;

    }

    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        lca l = new lca();
        l.lowestCommonAncestor(node1, node5, node6);
    }

}
