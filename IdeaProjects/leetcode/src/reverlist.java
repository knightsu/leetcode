/**
 * Created by yingyang on 4/29/17.
 */
public class reverlist {
    public static ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode bh = new ListNode(-1);
        bh.next=head;
        exchange(bh, head);
        return bh.next;
    }
    private static void exchange(ListNode bh, ListNode head)
    {
        if(head.next==null) return;
        ListNode change = head.next;
        change.next= bh.next;
        bh.next=change;

        exchange(bh, head);

    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        reverseList(l1);
    }
}
