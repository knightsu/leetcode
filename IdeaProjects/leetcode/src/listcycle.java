/**
 * Created by yingyang on 3/17/17.
 */
import datastucture.listnode;
public class listcycle {
    public static boolean hascycle(listnode head)
    {
        listnode p1 = head;
        listnode p2 = head;

        if(head==null) return false;
        if(head.next==head) return true;
        if(head.next==null) return  false;

        while(p1!=null&&p2!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
                return true;


        }
        return false;
    }

}
