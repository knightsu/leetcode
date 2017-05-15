/**
 * Created by yingyang on 9/11/15.
 */
public class addtwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null && l2 == null)
        {
            return null;
        }
        if((l1==null&&l2!=null) || (l1!=null&&l2==null))
        {
            if(l1==null)
            {
                return l2;
            }
            if(l2==null)
            {
                return l1;
            }
        }
        ListNode header = new ListNode(l1.val+l2.val);
        ListNode iter = header;
        int carry = 0;
        while(l1.next!=null || l2.next!=null)
        {
            if((l1.next==null&&l2.next!=null)||(l1.next!=null&&l2.next==null))
            {
                if(l1.next==null)
                {
                    int sum = l2.next.val+carry;
                    if(sum>=10)
                    {
                        ListNode node = new ListNode(sum%10);
                        iter.next = node;
                        carry = sum/10;
                        iter =node;
                    }
                    else
                    {
                        ListNode node = new ListNode(sum);
                        iter.next = node;
                        carry = 0;
                        iter =node;

                    }

                    //      l1=l1.next;
                    l2=l2.next;
                    continue;
                }
                if(l2.next==null)
                {
                    int sum = l1.next.val+carry;
                    if(sum>=10)
                    {
                        ListNode node = new ListNode(sum%10);
                        iter.next = node;
                        carry = sum/10;
                        iter=node;
                    }
                    else
                    {
                        ListNode node = new ListNode(sum);
                        iter.next = node;
                        carry = 0;
                        iter=node;
                    }

                    l1=l1.next;
                    //       l2=l2.next;
                    continue;
                }
                int sum = l1.next.val + l2.next.val+carry;
                if(sum>=10)
                {
                    ListNode node = new ListNode(sum%10);
                    iter.next = node;
                    carry = sum/10;
                    iter=node;
                }
                else
                {
                    ListNode node = new ListNode(sum);
                    iter.next = node;
                    carry = 0;
                    iter=node;
                }
                l1=l1.next;
                l2=l2.next;
            }
        }

        return header;

    }

    public static void main(String[] args)
    {
        ListNode l10 = new ListNode(3);
        ListNode l11 = new ListNode(7);
        ListNode l20 = new ListNode(9);
        ListNode l21 = new ListNode(2);
        l10.next = l11;
        l20.next = l21;
        addtwo addtwo = new addtwo();
        addtwo.addTwoNumbers(l10, l20);
    }
}
