/**
 * Created by yingyang on 4/16/17.
 */

import java.util.*;
public class gentree {

    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return null;

        List<TreeNode> res = new ArrayList<>();


        for(int i=1;i<=n;i++)
        {
            TreeNode root = new TreeNode(i);
            Set<Integer> temp = new HashSet<>();
            temp.add(i);
            backtrack(res, temp, n, root);
        }

        return res;



    }

    private static void backtrack(List<TreeNode> res, Set<Integer> temp, int n, TreeNode root)
    {
        if(temp.size()==n)
        {
            res.add(root);
            return;
        }

        for(int i=1;i<=n;i++)
        {
            if(!temp.contains(i))
            {
                TreeNode node = new TreeNode(i);
                if(temp.size()==1)
                {
                    if(root.val>i)
                    {
                        root.left=node;
                    }
                    else
                        root.right=node;
                }
                else   //find the right location to insert
                {
                    treeop(root, node, true);
                }
                temp.add(i);
                backtrack(res,temp, n, root);
                temp.remove(i);
                //remove the treenode from the tree
                treeop(root, node, false);
            }
        }
    }

    private static void treeop(TreeNode root, TreeNode node, boolean ops)    //T: insert, F delete
    {
        TreeNode iter = root;
        if(ops)
        {
            while(iter!=null)
            {
                if(iter.val>node.val)
                {
                    if(iter.left==null) break;
                    else  iter=iter.left;
                }

                else
                {
                    if(iter.right==null) break;
                    else    iter=iter.right;
                }
            }
            if(iter.val>node.val)
                iter.left=node;
            else
                iter.right=node;
        }
        else
        {
            while(iter!=null)
            {
                if(iter.val>node.val)
                {
                    if(iter.left.val==node.val) break;
                    else iter=iter.left;
                }
                else
                {
                    if(iter.right.val==node.val) break;
                    else iter=iter.right;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        generateTrees(3);
    }
}
