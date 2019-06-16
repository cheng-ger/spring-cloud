package com.cyl.it.gateway.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-31
 */
public class CookieUtil {
    public  static  void set(HttpServletResponse response ,
                             String name ,
                             String value,
                             int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge );
        response.addCookie(cookie);


    }

    public  static  Cookie get(HttpServletRequest request ,
                               String name ){

        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;

    }
}
