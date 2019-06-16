package com.cyl.it.user.dao;

import com.cyl.it.user.co.UserInfoCriteriaCO;
import com.cyl.it.user.dto.UserInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Repository
public interface UserInfoDao {

    List<UserInfoDTO> queryUserInfoByCondition(UserInfoCriteriaCO userInfoCriteriaCO);
}
