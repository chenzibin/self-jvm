package jvmparse;

/**
 * ExampleClass
 *
 * @author chenzb
 * @date 2019/11/4
 */
public class ExampleClass {

    int i = 0;
    Integer I = 0;
    float f = 1.0f;
    Float F = 1.0f;
    double d = 1.0;

    String s = "str";

    volatile int t;

    public void test() {
        t = 1;
        System.out.println(t);
    }
}
