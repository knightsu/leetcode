import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingyang on 3/12/17.
 */
public class insertinterval {
    public List<interval> insert(List<interval> intervals, interval insinterval)
    {
        List<interval> result = new ArrayList<>();
        interval temp = insinterval;
        for(interval i : intervals)
        {
            if(i.end<temp.start)
            {
                result.add(i);
            }
            else if(temp.end<i.start)
            {
                result.add(temp);
                temp=i;
            }
            else
            {
                temp=new interval(Math.min(temp.start,i.start), Math.max(temp.end,i.end));

            }



        }
        result.add(temp);
        return result;
    }

    public static void main(String[] args)
    {
        insertinterval isi = new insertinterval();
        interval i1 = new interval(1,2);
        interval i2 = new interval(3,5);
        interval i3 = new interval(6,7);
        interval i4 = new interval(8,10);
        interval i5 = new interval(12,16);
        interval insert = new interval(4,9);

        List<interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);


        List<interval> result = isi.insert(intervals, insert);

        for(interval i : result)
        {
            i.print();
        }

    }
}




