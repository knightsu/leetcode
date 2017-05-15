import java.util.Stack;

/**
 * Created by yingyang on 9/8/15.
 */
public class wr {

    public String reverseWords(String s) {

        String[] strarray = s.trim().split(" ");
        Stack<String> strstk = new Stack<String>();
        for(int i=0; i<strarray.length; i++)
        {
            if(!strarray[i].equals(" "))
            {
                strstk.push(strarray[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!strstk.isEmpty())
        {

            sb.append(strstk.pop().trim());
            sb.append(" ");
        }
        String res = sb.toString();
        int length = res.length();
        String fres = "";
        if(length==0)
        {
            fres = "";
        }
        else
        {fres = res.substring(0, length-1);}

        return fres;
    }

    public static void main(String[] args)
    {
        String input = "   a   b ";
        wr wr = new wr();
        wr.reverseWords(input);
    }
}
