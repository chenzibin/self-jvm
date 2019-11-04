package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * Created by chenzibin on 2019/11/2.
 */
@Data
public class MethodRef extends RefInfo {
    public MethodRef(ClassBuffer buffer, int tag) {
        super(buffer, tag);
    }
}
