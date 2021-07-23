package self.jvm.base.java.struct.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapTest
 *
 * @author chenzb
 * @date 2020/4/14
 */
public class HashMapTest {

    Map<String, String> map;

    @Before
    public void before() {
        map = new HashMap<>();
    }

    @Test
    public void testPut() {
        String url = "http://1/";
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        System.out.println(url + "/123");
    }
}
