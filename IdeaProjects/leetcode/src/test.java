import java.util.HashSet;
import java.util.Set;

/**
 * Created by yingyang on 4/26/17.
 */
public class test {
    private static test instance = null;

    private test(){}

    public static test gettest()
    {
        if(instance==null)
            synchronized (test.class) {
                if (instance == null) {
                    instance = new test();
                }
            }
        return instance;
    }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Set<Integer>[] adj = new Set[34];
        adj[0]=new HashSet<>();
        adj[0].add(1);
        test obj = test.class.newInstance();

    }
}
