/**
 * Created by yingyang on 9/7/15.
 */
public class bt {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || preorder.length!= inorder.length)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootindex = 0;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==root.val)
            {
                rootindex = i;
            }
        }

        buildTree(preorder,inorder, 0, inorder.length,rootindex, root);        //left

        return root;

    }

    private void buildTree(int[] preorder, int[] inorder, int start, int end, int rootindex, TreeNode root)
    {
        if(start==end)
        {
            if(start < rootindex)
            {
                TreeNode node = new TreeNode(inorder[start]);
                root.left = node;
                return;
            }
            if(start > rootindex)
            {
                TreeNode node = new TreeNode(inorder[start]);
                root.right = node;
                return;
            }
        }
        int index=0;
        for(int i=1; i<preorder.length;i++)
        {
            for(int j=start; j<end; j++)
            {
                if(preorder[i] == inorder[j])
                {
                    index = j;
                    if(index<rootindex)
                    {
                        TreeNode node = new TreeNode(inorder[index]);
                        root.left = node;
                    }
                    if(index>rootindex)
                    {
                        TreeNode node = new TreeNode(inorder[index]);
                        root.right = node;
                    }
                }
            }
            break;
        }
        if(index<rootindex)
        {
            buildTree(preorder,inorder, 0, rootindex, index, root.left);

        }
        if(index > rootindex)
        {
            buildTree(preorder, inorder, rootindex, preorder.length, index, root.right);
        }
    }

    public static void main(String[] args)
    {
        int[] pre = {1,2,3};
        int[] in = {3,2,1};

        bt bt1 = new bt();
        bt1.buildTree(pre, in);
    }

}
