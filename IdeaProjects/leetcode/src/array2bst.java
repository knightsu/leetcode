/**
 * Created by yingyang on 9/17/15.
 */
public class array2bst {

    public TreeNode sortedArrayToBST(int[] nums) {

        int length = nums.length;
        TreeNode root = new TreeNode(nums[length/2]);
        buildTree(root, nums, 0, length/2-1);
        buildTree(root, nums, length/2+1, length-1);

        return root;
    }

    private void buildTree(TreeNode root, int[] nums, int start, int end)
    {
        if(start==end)
        {
            TreeNode node = new TreeNode(nums[start]);
            if(root.val>node.val)
            {
                root.left= node;
            }
            else
            {
                root.right=node;
            }
            return;
        }
        TreeNode node = new TreeNode(nums[(end-start)/2]);
        if(root.val>node.val)
        {
            root.left= node;
        }
        else
        {
            root.right=node;
        }
        buildTree(node, nums, start, start+(end-start)/2-1);
        buildTree(node, nums, end-(end-start)/2+1, end);
    }

    public static void main(String[] args)
    {
        array2bst a2b = new array2bst();
        int[] a = {0,1,2,3,4,5,6};
        a2b.sortedArrayToBST(a);

    }
}
