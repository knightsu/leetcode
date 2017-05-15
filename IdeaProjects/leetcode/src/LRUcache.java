/**
 * Created by yingyang on 4/14/17.
 */
import java.util.*;
public class LRUcache {

    int size=0;
    int cap=0;
    Map<Integer, DLinkedList>  content = new HashMap<>();

    DLinkedList head, tail;

    public LRUcache(int capacity) {
        cap=capacity;
        head=new DLinkedList(-1,-1);
        tail=new DLinkedList(-1,-1);

        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(!content.containsKey(key))
            return -1;
        else
        {
            exchange(content.get(key));


            return content.get(key).value;
        }

    }

    public void put(int key, int value) {
        if(content.containsKey(key))
        {
            content.get(key).value=value;
            DLinkedList t = content.get(key);
            exchange(t);

        }
        else if(size==cap)
        {
            int a = remove();
            content.remove(a);
            DLinkedList node = new DLinkedList(key, value);
            content.put(key,node);
            add(node);
        }
        else
        {
            DLinkedList node = new DLinkedList(key, value);
            content.put(key,node);
            add(node);
            size++;
        }
    }

    private void add(DLinkedList t)
    {
        t.pre=tail.pre;
        t.pre.next=t;
        tail.pre=t;
        t.next=tail;
    }
    private int  remove()
    {
        DLinkedList t = head.next;
        head.next=head.next.next;
        head.next.pre=head;
        return t.key;
    }
    private void exchange(DLinkedList t)
    {
        t.pre.next = t.next;
        t.next.pre=t.pre;
        add(t);
    }

    public static void main(String[] args)
    {
        LRUcache cache = new LRUcache(2);
        cache.put(1,1);
        cache.put(2,2);
//
//
        cache.get(1);
        cache.put(3, 3);
//        cache.get(3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
//        cache.put(5, 5);
//        cache.get(1);
//        cache.get(2);
        cache.get(3);
        cache.get(4);
//        cache.get(5);



    }



}

class DLinkedList
{
    int key;
    int value;
    DLinkedList pre;
    DLinkedList next;
    DLinkedList(int k, int val)
    { key=k; value=val;}
}




