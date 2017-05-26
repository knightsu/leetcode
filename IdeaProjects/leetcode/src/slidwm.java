import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yingyang on 5/16/17.
 */
public class slidwm {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] max = new int[length-k+1];
        Deque<Integer> deck = new ArrayDeque<>();

        for(int i=0;i<length;i++)
        {
            while(!deck.isEmpty()&&deck.peekFirst()<i-k+1)
            {
                deck.poll();
            }
            while(!deck.isEmpty()&&nums[deck.peekLast()]<nums[i])
            {
                deck.pollLast();
            }
            deck.offer(i);
            if(i>=k-1)
            {
                max[i-k+1] = nums[deck.peekFirst()];
            }
        }
        return max;
    }



    public static void main(String[] args)
    {
        Stack<Integer> a = new Stack<>();
        a.size();
    }
}
