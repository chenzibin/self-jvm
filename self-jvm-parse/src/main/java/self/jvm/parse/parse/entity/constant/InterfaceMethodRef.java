package self.jvm.parse.parse.entity.constant;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * Created by chenzibin on 2019/11/2.
 */
@Data
public class InterfaceMethodRef extends RefInfo {

    public InterfaceMethodRef(ClassBuffer buffer, int tag) {
        super(buffer, tag);
    }
}
