/**
 * Created by yingyang on 5/8/17.
 */
import java.util.*;
public class cal {
    public static String preprocess(String s)    //remove empty remove ()
    {
        char[] sarr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> index = new Stack<>();
        char op = '+';int count = 0;
        for(int i=0;i<sarr.length;i++)
        {
            if(sarr[i]=='(')
            {
                if(count>0)
                {
                    index.push(op);
                }
                op = sb.charAt(sb.length()-1);
                count++;

            }
            if(sarr[i]==')')
            {
                count--;
                if(count>0)
                    op=index.pop();
                else
                    op='+';
            }
            if(sarr[i]!=' '&&sarr[i]!='('&&sarr[i]!=')')
            {
                if(op=='-')
                {
                    if(sarr[i]=='+')
                    {
                        sb.append('-');
                    }
                    else if(sarr[i]=='-')
                    {
                        sb.append('+');
                    }
                    else
                        sb.append(sarr[i]);
                }
                else
                    sb.append(sarr[i]);
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args)
//    {
//        String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
//        System.out.print(preprocess(s));
//
////        int[] a = {1,2,4,5,6,5};
////        String s = a[0] + '-' + a[1] + "-";
////        System.out.print(s);
//    }

}
