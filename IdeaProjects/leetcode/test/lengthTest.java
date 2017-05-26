import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by yingyang on 5/13/17.
 */
public class lengthTest {
    //Map<Integer, Integer> map = new HashMap<>();
    int a = 4;
    length len= new length();


    @Test
    public void testCountpre() throws Exception {
        len.countpre(a);
        assertEquals(300L, (long)len.map.get(3));


    }
}