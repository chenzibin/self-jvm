package self.jvm.parse.parse;

/**
 * ClassParse
 *
 * @author chenzb
 * @date 2019/10/30
 */
public class ClassParse {

    private ClassBuffer buffer;

    public static ClassParse classPath(String classPath) {
        return new ClassParse(new ClassBuffer(classPath));
    }

    private ClassParse(ClassBuffer buffer) {
        this.buffer = buffer;
    }

    public ClassFormat parse() {
        return new ClassFormat(buffer);
    }

}
