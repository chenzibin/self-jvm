package self.jvm.parse.parse.factory;

import self.jvm.parse.parse.ClassBuffer;
import self.jvm.parse.parse.entity.ConstantPool;
import self.jvm.parse.parse.entity.attribute.*;
import self.jvm.parse.parse.entity.attribute.Deprecated;
import self.jvm.parse.parse.entity.constant.Utf8;

/**
 * AttributeFactory
 *
 * @author chenzb
 * @date 2019/11/11
 */
public class AttributeFactory {

    public static final String CONSTANT_VALUE                           = "ConstantValue";
    public static final String CODE                                     = "Code";
    public static final String STACK_MAP_TABLE                          = "StackMapTable";
    public static final String EXCEPTIONS                               = "Exceptions";
    public static final String INNER_CLASSES                            = "InnerClasses";
    public static final String ENCLOSING_METHOD                         = "EnclosingMethod";
    public static final String SYNTHETIC                                = "Synthetic";
    public static final String SIGNATURE                                = "Signature";
    public static final String SOURCE_FILE                              = "SourceFile";
    public static final String SOURCE_DEBUG_EXTENSION                   = "SourceDebugExtension";
    public static final String LINE_NUMBER_TABLE                        = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE                     = "LocalVariableTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE                = "LocalVariableTypeTable";
    public static final String DEPRECATED                               = "Deprecated";
    public static final String RUNTIME_VISIBLE_ANNOTATIONS              = "RuntimeVisibleAnnotations";
    public static final String RUNTIME_INVISIBLE_ANNOTATIONS            = "RuntimeInvisibleAnnotations";
    public static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS    = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS  = "RuntimeInvisibleParameterAnnotations";
    public static final String ANNOTATION_DEFAULT                       = "AnnotationDefault";
    public static final String BOOTSTRAP_METHODS                        = "BootstrapMethods";

    public Attribute getAttribute(ClassBuffer buffer, ConstantPool constantPool) {
        int attributeNameIndex = buffer.u2();
        Utf8 utf8 = (Utf8) constantPool.getConstants()[attributeNameIndex];
        System.out.println(utf8.getBytes());
        switch (utf8.getBytes()) {
            case CONSTANT_VALUE:
                return new ConstantValue(buffer, attributeNameIndex);
            case CODE:
                return new Code(buffer, attributeNameIndex, constantPool);
            case STACK_MAP_TABLE:
                return new ConstantValue(buffer, attributeNameIndex);
            case EXCEPTIONS:
                return new Exceptions(buffer, attributeNameIndex);
            case INNER_CLASSES:
                return new ConstantValue(buffer, attributeNameIndex);
            case ENCLOSING_METHOD:
                return new ConstantValue(buffer, attributeNameIndex);
            case SYNTHETIC:
                return new ConstantValue(buffer, attributeNameIndex);
            case SIGNATURE:
                return new ConstantValue(buffer, attributeNameIndex);
            case SOURCE_FILE:
                return new ConstantValue(buffer, attributeNameIndex);
            case SOURCE_DEBUG_EXTENSION:
                return new ConstantValue(buffer, attributeNameIndex);
            case LINE_NUMBER_TABLE:
                return new LineNumberTable(buffer, attributeNameIndex);
            case LOCAL_VARIABLE_TABLE:
                return new LocalVariableTable(buffer, attributeNameIndex);
            case LOCAL_VARIABLE_TYPE_TABLE:
                return new ConstantValue(buffer, attributeNameIndex);
            case DEPRECATED:
                return new Deprecated(buffer, attributeNameIndex);
            case RUNTIME_VISIBLE_ANNOTATIONS:
                return new RuntimeVisibleAnnotations(buffer, attributeNameIndex);
            case RUNTIME_INVISIBLE_ANNOTATIONS:
                return new ConstantValue(buffer, attributeNameIndex);
            case RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
                return new ConstantValue(buffer, attributeNameIndex);
            case RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
                return new ConstantValue(buffer, attributeNameIndex);
            case ANNOTATION_DEFAULT:
                return new ConstantValue(buffer, attributeNameIndex);
            case BOOTSTRAP_METHODS:
                return new ConstantValue(buffer, attributeNameIndex);
            default:
                return null;
        }
    }
}
