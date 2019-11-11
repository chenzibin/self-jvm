package jvmparse;

import com.alibaba.fastjson.JSONObject;
import jvmparse.parse.ClassFormat;
import jvmparse.parse.ClassParse;

import java.io.IOException;

/**
 * ParseFoarmat
 *
 * @author chenzb
 * @date 2019/10/31
 */
public class ParseFormat {

    public static void main(String[] args) throws IOException {
        String classPath = "F:\\work\\code\\jvm-java\\jvm-parse\\out\\test\\classes\\jvmparse\\ExampleClass.class";
        ClassFormat format = ClassParse.classPath(classPath).parse();
        System.out.println(format.toString());
        System.out.println(JSONObject.toJSONString(format, true));
    }
}
