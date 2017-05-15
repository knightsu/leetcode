/**
 * Created by yingyang on 4/22/17.
 */
import java.util.*;
public class gene {

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }


    public static void main(String[] args) {
        findRepeatedDnaSequences("GATGGATACTGCATTCGAACCAGAGCCGGCTTTTGCGGGACTAGCATGAGGGACTTGGCTGTTGAGGCTGTACATTTTTGCAACTCCACTGCTTATAATCCACCAAGTCCAGACTCAAAGCTCAACTCGGGGATCGC");
    }

}
