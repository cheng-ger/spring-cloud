package com.cyl.it.user.service;

import com.cyl.it.user.co.UserInfoCriteriaCO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */

public interface UserInfoService {

    String loginBuyer(UserInfoCriteriaCO userInfoCriteriaCO, HttpServletResponse response);

    String loginSeller(UserInfoCriteriaCO userInfoCriteriaCO, HttpServletRequest request, HttpServletResponse response);
}
