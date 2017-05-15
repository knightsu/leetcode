/**
 * Created by yingyang on 4/14/17.
 */
public class insertionlist {

    public static ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode temphead = new ListNode(Integer.MIN_VALUE);
        temphead.next=head;
        ListNode iterf=head.next, iters=head, comf=head, coms=temphead;
        int size=1;
        while(iterf!=null)
        {
            comf=head; coms=temphead;
            int i=0;
            while(comf.val<=iterf.val&&i<size)
            {
                comf=comf.next;
                coms=coms.next;
                i++;
            }
            //swithch
            if(i<size)
            {
                iters.next=iterf.next;
                iterf.next=comf;
                coms.next=iterf;
                iterf=iters.next;
                size++;
            }
            else
            {
                iterf=iterf.next;
                iters=iters.next;
                size++;
            }
        }

        return temphead.next;
    }

    public static void main(String[] args)
    {
        ListNode l1=new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);

        l1.next=l2;
        l2.next=l3;

        insertionSortList(l1);
    }
}
