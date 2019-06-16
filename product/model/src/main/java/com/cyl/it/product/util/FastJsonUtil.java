package com.cyl.it.product.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-28
 */
public class FastJsonUtil {

    /*
     * 将对象（bean list）转化为json
     */
    public static String objectTOjson(Object data){

        String str = JSON.toJSONString(data);
        return str;
    }

    /*
     * 将单个json 转化为单个对象
     */
    public static <T> T  jsonToObject(String data,Class<T> beanType){

        T t = JSONObject.parseObject(data ,beanType);

        return t;

    }


    /*
     * 将json转化为List<T>
     */

    public static <T> List<T> jsonToList(String data , Class<T> beanType){


        List<T> list = JSONObject.parseArray(data, beanType);
        return list;

    }
}
