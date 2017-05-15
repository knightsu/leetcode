/**
 * Created by yingyang on 9/4/15.
 */
public class Connect {

    public void connect(TreeLinkNode root) {

        //root.next = null;

        if(root==null)
        {
            return;
        }

        if(root.left!=null)
        {
            if(root.right!=null)
            {
                root.left.next=root.right;
            }
            else
            {
                root.left=null;

            }
        }

        connectsubtree(root.left);

    }
    public void connectsubtree(TreeLinkNode root)
    {
        if(root==null)
        {
            return;
        }

        if(root.left!=null)
        {
            if(root.right!=null)
            {
                root.left.next=root.right;
            }
            if(root.next!=null)
            {
                root.right.next=root.next.left;
            }
        }

        connectsubtree(root.left);
        connectsubtree(root.right);
    }

    public static void main(String[] args)
    {
        TreeLinkNode node0 = new TreeLinkNode(0);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);

        node0.left=node1;
        node0.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;


        Connect cc = new Connect();
        cc.connect(node0);

    }
}
