package cparse;

import cparse.parse.ClassFormat;
import cparse.parse.ClassParse;

import java.io.IOException;

/**
 * ParseFoarmat
 *
 * @author chenzb
 * @date 2019/10/31
 */
public class ParseFoarmat {

    public static void main(String[] args) throws IOException {
        String classPath = "F:\\learn\\udap-test\\target\\classes\\sync\\SyncTest.class";
        ClassFormat format = ClassParse.classPath(classPath).parse();
        System.out.println(format.toString());
    }
}
