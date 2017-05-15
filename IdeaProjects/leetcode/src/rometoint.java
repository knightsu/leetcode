/**
 * Created by yingyang on 3/24/17.
 */
public class rometoint {
    public static int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            String temp;
            if ((i + 1) < length) {
                temp = s.substring(i, i + 2);
                if (temp == "IV") {
                    result = result + 4;
                    i++;
                    continue;
                }
                if (temp == "IX") {
                    result = result + 9;
                    i++;
                    continue;
                }
                if (temp == "XL") {
                    result = result + 40;
                    i++;
                    continue;
                }
                if (temp == "XC") {
                    result = result + 90;
                    i++;
                    continue;
                }
                if (temp == "CD") {
                    result = result + 400;
                    i++;
                    continue;
                }
                if (temp == "CM") {
                    result = result + 900;
                    i++;
                    continue;
                }
            }
            if (s.charAt(i) == 'I') {
                result = result + 1;
            } else if (s.charAt(i) == 'V') {
                result = result + 5;
            } else if (s.charAt(i) == 'X') {
                result = result + 10;

            } else if (s.charAt(i) == 'L') {
                result = result + 50;
            } else if (s.charAt(i) == 'C') {
                result = result + 100;
            } else if (s.charAt(i) == 'D') {
                result = result + 500;
            } else if (s.charAt(i) == 'M') {
                result = result + 1000;
            } else return -1;
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(romanToInt("MCMXCVI"));
    }
}
