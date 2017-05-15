/**
 * Created by yingyang on 4/15/17.
 */
import java.util.*;
public class RPN {
    public static int evalRPN(String[] tokens) {

        int len=tokens.length;
        Stack<String> temp = new Stack<>();
        for(int i=0;i<len;i++)
        {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/"))
            {
                int a = Integer.parseInt(temp.pop());
                int b = Integer.parseInt(temp.pop());

                if(tokens[i]=="+")
                {
                    int c = a+b;
                    String s = new Integer(c).toString();
                    temp.push(s);
                }
                else if(tokens[i]=="-")
                {
                    int c = b-a;
                    String s = new Integer(c).toString();
                    temp.push(s);
                }
                else if(tokens[i]=="*")
                {
                    int c = a*b;
                    String s = new Integer(c).toString();
                    temp.push(s);
                }
                else
                {
                    int c=b/a;
                    String s = new Integer(c).toString();
                    temp.push(s);
                }
            }
            else
            {
                temp.push(tokens[i]);
            }
        }
        int res = Integer.parseInt(temp.pop());
        return res;
    }

    public static void main(String[] args)
    {
//        String[] a = {"4","-2","/","2","-3","-","-"};
//        evalRPN(a);

        String s ="askd safdsa  asdfdsa   sdadf";
        String[] a = s.split(" ");


    }
}
