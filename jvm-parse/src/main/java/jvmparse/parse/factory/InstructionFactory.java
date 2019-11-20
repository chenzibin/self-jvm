package jvmparse.parse.factory;

/**
 * InstructionFactory
 *
 * @author chenzb
 * @date 2019/11/20
 */
public class InstructionFactory {

    public static final int CONSTANT_CLASS = 7;
    public static final int CONSTANT_FIELD_REF = 9;
    public static final int CONSTANT_METHOD_REF = 10;
    public static final int CONSTANT_INTERFACE_METHOD_REF = 11;
    public static final int CONSTANT_STRING = 8;
    public static final int CONSTANT_INTEGER = 3;
    public static final int CONSTANT_FLOAT = 4;
    public static final int CONSTANT_LONG = 5;
    public static final int CONSTANT_DOUBLE = 6;
    public static final int CONSTANT_NAME_AND_TYPE = 12;
    public static final int CONSTANT_UTF8 = 1;
    public static final int CONSTANT_METHOD_HANDLE = 15;
    public static final int CONSTANT_METHOD_TYPE = 16;
    public static final int CONSTANT_INVOKE_DYNAMIC = 18;
}
