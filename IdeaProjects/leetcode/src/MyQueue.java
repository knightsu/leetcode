import java.util.Stack;

/**
 * Created by yingyang on 5/14/17.
 */
public class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    boolean flag;
    /** Initialize your data structure here. */
    public MyQueue() {
        first = new Stack<Integer>();
        second = new Stack<Integer>();
        flag=true;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(first.isEmpty()&&second.isEmpty())
        {
            first.push(x);
        }
        if(flag) second.push(x);
        else first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(flag)
        {
            int a = first.pop();
            while(second.size()>1)
            {
                first.push(second.pop());
            }
            flag=false;
            return a;
        }
        else
        {
            int a = second.pop();
            while(first.size()>1)
            {
                second.push(first.pop());
            }
            flag=true;
            return a;
        }
    }

    /** Get the front element. */
    public int peek() {
        if(flag) return first.peek();
        else return second.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.isEmpty()&&second.isEmpty();
    }

    public static void main(String[] args)
    {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.pop();
        mq.empty();

    }
}
