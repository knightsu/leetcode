/**
 * Created by yingyang on 4/7/17.
 */
public class treelink {
    public static void connect(TreeLinkNode root) {
        int height = getheight(root);
        TreeLinkNode temp = root;
        int level=0;
        while(level<height-1)
        {
            TreeLinkNode iter = temp;
            TreeLinkNode ntemp;
            while(iter!=null)
            {
                if(iter.left==null&&iter.right==null)
                {
                    iter=iter.next;
                }
                else
                {
                    if(iter.left!=null)
                    {
                        temp=iter.left;
                    }
                    else
                        temp=iter.right;
                    break;
                }
            }
            if(iter==null) return;
            if(temp==iter.left&&iter.right!=null)
            {
                temp.next=iter.right;
                ntemp=temp.next;
            }
            iter=iter.next;
            ntemp=temp;
            while(iter!=null)
            {
                if(iter.left==null&&iter.right==null)
                {
                    iter=iter.next;
                }
                else if(iter.left!=null&&iter.right==null)
                {
                    ntemp.next=iter.left;
                    ntemp=ntemp.next;
                }
                else if(iter.left==null&&iter.right!=null)
                {
                    ntemp.next=iter.right;
                    ntemp=ntemp.next;
                }
                else
                {
                    iter.left.next=iter.right;
                    ntemp.next=iter.left;
                    ntemp=ntemp.next.next;
                }
            }
            level++;
        }


    }

    private static int getheight(TreeLinkNode root)
    {
        if(root==null) return 0;
        return Math.max(getheight(root.left), getheight(root.right))+1;
    }

    public static void main(String[] args)
    {
        TreeLinkNode t1=new TreeLinkNode(1);
        TreeLinkNode t2=new TreeLinkNode(2);
        TreeLinkNode t3=new TreeLinkNode(3);
        TreeLinkNode t4=new TreeLinkNode(4);
        TreeLinkNode t5=new TreeLinkNode(5);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.right=t5;

        connect(t1);

    }

}
