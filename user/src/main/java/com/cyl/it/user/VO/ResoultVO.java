package com.cyl.it.user.VO;

import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Data
public class ResoultVO {

    private Integer code;

    private String msg;

    private  Object data;


    public ResoultVO() {
    }

    public ResoultVO(Integer code) {
        this.code = code;
    }


    public ResoultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
