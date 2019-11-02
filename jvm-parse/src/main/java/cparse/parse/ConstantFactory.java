package cparse.parse;

import cparse.parse.entity.constant.*;

/**
 * ConstantFactory
 *
 * @author chenzb
 * @date 2019/11/1
 */
public class ConstantFactory {

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

    public Constant getConstant(ClassBuffer buffer) {
        int tag = buffer.u1();
        switch (tag) {
            case CONSTANT_CLASS:
                return new ClassInfo(buffer, tag);
            case CONSTANT_FIELD_REF:
            case CONSTANT_METHOD_REF:
            case CONSTANT_INTERFACE_METHOD_REF:
                return new RefInfo(buffer, tag);
            case CONSTANT_STRING:
                return new StringInfo(buffer, tag);
            case CONSTANT_INTEGER:
                return new IntegerInfo(buffer, tag);
            case CONSTANT_FLOAT:
                return new FloatInfo(buffer, tag);
            case CONSTANT_LONG:
                return new LongInfo(buffer, tag);
            case CONSTANT_DOUBLE:
                return new DoubleInfo(buffer, tag);
            case CONSTANT_NAME_AND_TYPE:
                return new NameAndType(buffer, tag);
            case CONSTANT_UTF8:
                return new Utf8(buffer, tag);
            case CONSTANT_METHOD_HANDLE:
                return new MethodHandleConstant(buffer, tag);
            case CONSTANT_METHOD_TYPE:
                return new MethodTypeConstant(buffer, tag);
            case CONSTANT_INVOKE_DYNAMIC:
                return new InvokeDynamic(buffer, tag);
            default:
                throw new IllegalArgumentException("unknown constant pool tag " + tag);
        }
    }
}
