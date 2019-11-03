package cparse.parse.entity;

import cparse.parse.ClassBuffer;
import cparse.parse.ConstantFactory;
import cparse.parse.entity.constant.Constant;

/**
 * Created by chenzibin on 2019/11/2.
 */
public class ConstantPool {

    private Constant[] constants;

    public ConstantPool(ClassBuffer buffer, int constantPoolCount) {
        this.constants = new Constant[constantPoolCount];
        ConstantFactory constantFactory = new ConstantFactory();
        for (int i = 1; i < constantPoolCount; i++) {
            Constant constant = constantFactory.getConstant(buffer);
            constants[i] = constant;
            if (constant.getTag() == ConstantFactory.CONSTANT_DOUBLE ||
                    constant.getTag() == ConstantFactory.CONSTANT_LONG) {
                i++;
            }
        }

    }
}
