package cparse.parse.entity.constant;

import lombok.Data;

/**
 * Constant
 *
 * @author chenzb
 * @date 2019/10/31
 */
@Data
public class Constant {

    /**
     * u1   tag
     * u1   info[]
     */
    private int tag;

    public Constant(int tag) {
        this.tag = tag;
    }

}
