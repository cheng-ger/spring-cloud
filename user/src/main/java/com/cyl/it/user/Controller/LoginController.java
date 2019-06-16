package com.cyl.it.user.Controller;

import com.cyl.it.user.VO.ResoultVO;
import com.cyl.it.user.co.UserInfoCriteriaCO;
import com.cyl.it.user.service.UserInfoService;
import com.cyl.it.user.util.ResoultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@RestController
@RequestMapping("loginService")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("buyerLogin")
    private ResoultVO buyerLogin(@RequestParam String openId , HttpServletResponse response){

        UserInfoCriteriaCO userInfoCriteriaCO = new UserInfoCriteriaCO();
        userInfoCriteriaCO.setOpenId(openId);
        String msg = userInfoService.loginBuyer(userInfoCriteriaCO,response);

        return ResoultVOUtil.success(msg);
    }

    @GetMapping("sellerLogin")
    private ResoultVO sellerLogin(@RequestParam String openId , HttpServletRequest request,
                                  HttpServletResponse response){

        UserInfoCriteriaCO userInfoCriteriaCO = new UserInfoCriteriaCO();
        userInfoCriteriaCO.setOpenId(openId);
        String msg = userInfoService.loginSeller(userInfoCriteriaCO, request, response);

        return ResoultVOUtil.set(msg);
    }
}
