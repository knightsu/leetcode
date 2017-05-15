/**
 * Created by yingyang on 3/30/17.
 */
public class permutation {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode iter=head;
        ListNode res=head;
        while(iter.next!=null)
        {
            iter=iter.next;
        }

        for(int i=1;i<=k;i++)
        {
            iter.next=res;
            res=iter;
            ListNode titer=res;
            while(titer.next!=res)
            {
                titer=titer.next;
            }
            titer.next=null;
        }
        return res;
    }

    public static void main(String[] args)
    {
        ListNode l1= new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        rotateRight(l1, 2);
    }
}
