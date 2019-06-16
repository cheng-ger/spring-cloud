package com.cyl.it.user.util;

import com.cyl.it.user.VO.ResoultVO;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
public class ResoultVOUtil {

    public  static ResoultVO success(Object o) {
        ResoultVO resoultVO = new ResoultVO(0, "成功", o);

        return resoultVO;
    }

    public  static ResoultVO  set( String msg ) {
        ResoultVO resoultVO = new ResoultVO(0, msg, null);

        return resoultVO;
    }

    public  static ResoultVO error(Object o) {
        ResoultVO resoultVO = new ResoultVO(1, "失败", o);

        return resoultVO;
    }

}
