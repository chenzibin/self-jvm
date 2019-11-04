package jvmparse;

import jvmparse.parse.ClassFormat;
import jvmparse.parse.ClassParse;
import org.junit.Test;

import java.io.IOException;

/**
 * ParseFormat
 *
 * @author chenzb
 * @date 2019/11/4
 */
public class ParseFormat {

    @Test
    public void test() throws IOException {
        String classPath = "F:\\work\\code\\jvm-java\\jvm-parse\\out\\test\\classes\\jvmparse\\ExampleClass.class";
        ClassFormat format = ClassParse.classPath(classPath).parse();
        System.out.println(format.toString());
    }
}
