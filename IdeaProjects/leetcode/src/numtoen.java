import java.util.Stack;

/**
 * Created by yingyang on 5/26/17.
 */


public class numtoen {
    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        Stack<Integer> digits = new Stack<>();
        while(num>=10)
        {
            digits.push(num%10);
            num=num/10;
        }
        digits.push(num);
        int level = digits.size()/3;
        if(digits.size()%3!=0)
            level++;
        StringBuilder sb = new StringBuilder();
        int head = digits.size()%3;
        if(head==1)
        {
            int a = digits.pop();
            sb.append(convert(a, "ge"));
            sb.append(" ");
            sb.append(convert(level));
            level--;
        }
        if(head==2)
        {
            int a=digits.pop();
            int b=digits.pop();
            if(a==0)
                sb.append(convert(b, "ge"));
            else if(a==1)
            {
                if(b==0)
                    sb.append("Ten");
                sb.append(convert(b,"shiji"));
            }
            else
            {
                sb.append(convert(a, "shi"));
                sb.append(" ");
                sb.append(convert(b, "ge"));
            }
            sb.append(" ");
            sb.append(convert(level));
            level--;
        }

        while(level>0)
        {
            int a = digits.pop();
            int b = digits.pop();
            int c = digits.pop();


            if(a!=0)
            {
                sb.append(" ");
                sb.append(convert(a, "ge"));
                sb.append(" ");
                sb.append("Hundred");
            }
            if(b!=0)
            {
                sb.append(" ");
                if(b==1)
                {
                    sb.append(convert(c, "shiji"));
                }
                else
                {
                    sb.append(convert(b, "shi"));
                    sb.append(" ");
                    sb.append(convert(c, "ge"));
                }
            }
            sb.append(" ");
            sb.append(convert(level));
            level--;

        }
        return sb.toString().trim();

    }
    private static String convert(int level)
    {
        switch(level)
        {
            case 2:
                return "Thousand";
            case 3:
                return "Million";
            case 4:
                return "Billion";
            default:
                return "";
        }

    }
    private static String convert(int d, String flag)
    {
        if(flag.equals("shi"))  //ty 20 30
        {
            switch(d)
            {
                case 2:
                    return "Twenty";
                case 3:
                    return "Thirty";
                case 4:
                    return "Forty";
                case 5:
                    return "Fifty";
                case 6:
                    return "Sixty";
                case 7:
                    return "Seventy";
                case 8:
                    return "Eighty";
                case 9:
                    return "Ninety";
                default:
                    return "";
            }
        }
        else if(flag.equals("ge"))
        {
            switch(d)
            {
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eight";
                case 9:
                    return "Nine";
                default:
                    return "";
            }
        }
        else if(flag.equals("shiji"))
        {
            switch(d)
            {
                case 0:
                    return "Ten";
                case 1:
                    return "Eleven";
                case 2:
                    return "Twelve";
                case 3:
                    return "Thirteen";
                case 4:
                    return "Fourteen";
                case 5:
                    return "Fifteen";
                case 6:
                    return "Sixteen";
                case 7:
                    return "Seventeen";
                case 8:
                    return "Eighteen";
                case 9:
                    return "Nineteen";
                default:
                    return "";
            }
        }
        return "";
    }

    public static void main(String[] args)
    {
        numberToWords(10);
    }
}
