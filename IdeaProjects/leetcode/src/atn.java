/**
 * Created by yingyang on 3/15/17.
 */

import datastucture.listnode;



public class atn {
    public static listnode add(listnode a, listnode b)
    {
        if(b==null || a==null)
            return a==null? b: a;
        int carry=0;
        listnode c = new listnode(0);
        listnode p1=a;
        listnode p2=b;
        listnode p3=c;

        while(p1!=null&&p2!=null)
        {
            int sum = p1.val+p2.val+carry;
            if(sum >= 10)
            {
                sum=sum%10;
                carry=1;
            }
            else carry=0;

            p3.next=new listnode(sum);
            p1=p1.next;
            p2=p2.next;
            p3=p3.next;
        }

        if(carry==1 || p1!=null || p2!=null)
        {
            if(p1==null && p2==null) {
                p3.next = new listnode(carry);

            }
            else
            {
                if(p1!=null)
                {
                    while (p1!=null) {
                        int sum = p1.val + carry;
                        if (sum > 10) {
                            sum = sum % 10;
                            carry = 1;
                        } else carry = 0;
                        p3 = new listnode(sum);
                        p1 = p1.next;
                        p3 = p3.next;
                    }
                }
                else
                {
                    while (p2!=null)
                    {
                        int sum = p2.val + carry;
                        if (sum > 10) {
                            sum = sum % 10;
                            carry = 1;
                        } else carry = 0;
                        p3 = new listnode(sum);
                        p2 = p2.next;
                        p3 = p3.next;
                    }
                }
            }

        }

        return c.next;

    }

    public static void main(String[] args)
    {
        listnode a = new listnode(2);
        listnode a1 = new listnode(4);
        listnode a2 = new listnode(3);
        a.next=a1;
        a1.next=a2;

        listnode b = new listnode(5);
        listnode b1 = new listnode(6);
        listnode b2 = new listnode(4);
        b.next = b1;
        b1.next = b2;

        listnode c = add(a,b);

        while (c!=null)
        {
            System.out.println(c.val);
            c=c.next;
        }
    }
}
