/**
 * Created by yingyang on 4/25/17.
 */
public class WordDictionary {
    node root;

    private static class node
    {
        boolean exist;
        node[] next = new node[26];
    }


    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root = addWord(word, 0, root);
    }

    private node addWord(String word, int d, node root)
    {
        if(root==null) root = new node();
        if(d==word.length())
        {
            root.exist=true; return root;
        }
        char c = word.charAt(d);
        root.next[c-97]=addWord(word, d+1, root.next[c-97]);
        return root;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int d, node root)
    {
        if(root==null) return false;
        if(d==word.length()) return root.exist;
        char c=word.charAt(d); boolean exist=false;
        if(c=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(root.next[i]!=null)
                {
                    exist= search(word, d+1, root.next[i]);
                }
                if(exist) break;
            }

            return exist;
        }
        else
            return search(word, d+1, root.next[c-97]);

    }

    public static void main(String[] args)
    {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        wd.search("aa");
    }

}
