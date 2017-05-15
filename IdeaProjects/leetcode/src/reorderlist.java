/**
 * Created by yingyang on 3/16/17.
 */
import datastucture.listnode;
import java.util.*;

public class reorderlist {
    public static void orderList(ListNode head) {
        Stack<ListNode> temp = new Stack<>();
        ListNode iter = head;
        int size=0;
        while(iter!=null)
        {
            size++;
            iter=iter.next;
        }
        iter = head;
        if(size%2==0)
        {
            for(int i=0;i<size/2; i++)
            {
                iter=iter.next;
            }
        }
        else
        {
            for(int i=0;i<=size/2;i++)
            {
                iter=iter.next;
            }
        }

        while(iter!=null)
        {
            temp.push(iter);
            iter=iter.next;
        }
        iter=head;

        while(!temp.isEmpty())
        {
            ListNode ln = temp.pop();
            ln.next=iter.next;
            iter.next=ln;
            iter=ln.next;
        }




    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        listnode l3 = new listnode(3);
//        listnode l4 = new listnode(4);
//        listnode l5 = new listnode(5);
//     //   listnode l6 = new listnode(6);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;

        orderList(l1);
        ListNode p1 = l1;
        while (p1!=null)
        {
            System.out.println(p1.val);
            p1=p1.next;
        }

    }
}

