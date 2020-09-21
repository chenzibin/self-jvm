package self.jvm.parse;

import com.alibaba.fastjson.JSONObject;
import self.jvm.parse.parse.ClassFormat;
import self.jvm.parse.parse.ClassParse;

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
