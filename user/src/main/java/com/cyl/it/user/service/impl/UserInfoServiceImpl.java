package com.cyl.it.user.service.impl;

import com.cyl.it.user.co.UserInfoCriteriaCO;
import com.cyl.it.user.dao.UserInfoDao;
import com.cyl.it.user.dto.UserInfoDTO;
import com.cyl.it.user.enums.UserInfoEnum;
import com.cyl.it.user.service.UserInfoService;
import com.cyl.it.user.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String loginBuyer(UserInfoCriteriaCO userInfoCriteriaCO, HttpServletResponse response) {

        List<UserInfoDTO> userInfoDTOList = userInfoDao.queryUserInfoByCondition(userInfoCriteriaCO);

        if(userInfoDTOList.isEmpty()){
            return UserInfoEnum.LOGIN_FAIL.getMsg();
        }
        if(! UserInfoEnum.BUYER.getCode().equals(userInfoDTOList.get(0).getRole())){
            return UserInfoEnum.ROLE_ERROR.getMsg();
        }
        /*设置cookie   openId */
        CookieUtil.set(response, "openId",userInfoCriteriaCO.getOpenId(),7200);
        return  UserInfoEnum.LOGIN_SUC.getMsg();

    }

    @Override
    public String loginSeller(UserInfoCriteriaCO userInfoCriteriaCO,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        String keyTemplate = "token_%s";

        //判断是否登录  不重复在redis中写数据
        Cookie cookie = CookieUtil.get(request, "token");
        if(null != cookie &&
                !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(keyTemplate, cookie.getValue())))){
            return UserInfoEnum.LOGIN_IN.getMsg();
        }

        List<UserInfoDTO> userInfoDTOList = userInfoDao.queryUserInfoByCondition(userInfoCriteriaCO);
        //判数据库是否有
        if(userInfoDTOList.isEmpty()){
            return UserInfoEnum.LOGIN_FAIL.getMsg();
        }
        // 角色
        if(! UserInfoEnum.SELLER.getCode().equals(userInfoDTOList.get(0).getRole())){
            return UserInfoEnum.ROLE_ERROR.getMsg();
        }
        //设置redis key ==token_UUID  ，value = openId
        String uuId = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(  String.format(keyTemplate, uuId) , userInfoCriteriaCO.getOpenId(),
                                         7200, TimeUnit.SECONDS);
        //cookie中设置token=UUID
        CookieUtil.set(response, "token",uuId,7200);

        return UserInfoEnum.LOGIN_SUC.getMsg();

    }
}
