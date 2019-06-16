package com.cyl.it.product.util;

import com.cyl.it.product.vo.ResoultVO;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
public class ResultVOUtil {

    public  static ResoultVO success(Object o){
        ResoultVO resoultVO = new ResoultVO(0, "成功", o);

        return resoultVO;
    }
}
