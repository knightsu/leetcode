import java.util.*;

/**
 * Created by yingyang on 3/8/17.
 */
public class mergeinterval {
    public List<interval> merge (List<interval>  intervals)
    {
        if(intervals==null || intervals.size()==1)
        {
            return  intervals;
        }

        Collections.sort(intervals,new intervalcmp());

        List<interval> result = new ArrayList<interval>();
        interval preint = intervals.get(0);
        for(int i=1; i<intervals.size();i++)
        {

            interval curint = intervals.get(i);
            if(preint.end<curint.start)
            {
                result.add(preint);
                preint=curint;
            }
            else
            {
                if(preint.end<curint.end)
                {
                    interval merge = new interval(preint.start, curint.end);
                    preint=merge;
                }
            }

        }

        result.add(preint);




        return result;
    }

    public static void main(String[] args)
    {
        mergeinterval mi = new mergeinterval();
        interval i1 = new interval(1,3);
        interval i2 = new interval(2,6);
        interval i3 = new interval(8,10);
        interval i4 = new interval(15, 18);

        List<interval> tomerge = new ArrayList<>();
        tomerge.add(i1);
        tomerge.add(i2);
        tomerge.add(i3);
        tomerge.add(i4);

        List<interval> result = mi.merge(tomerge);
        for(interval i : result)
        {
            i.print();
        }
    }

}


//assist class
class interval {
    int start;
    int end;
    interval()
    {
        start=0;
        end=0;
    }
    interval(int s, int e)
    {
        start=s;
        end=e;
    }
    public void print()
    {
        System.out.println("[" + start + "," +end+"]");
    }
}

class intervalcmp implements Comparator<interval>
{
    public int compare(interval i1, interval i2)
    {
        return  i1.start-i2.start;
    }
}


