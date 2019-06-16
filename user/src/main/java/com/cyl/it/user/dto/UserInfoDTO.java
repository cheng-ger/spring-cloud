package com.cyl.it.user.dto;

import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Data
public class UserInfoDTO {
    /*user_id BIGINT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) DEFAULT '',
            `password` VARCHAR(64) DEFAULT '',
            `open_id`  VARCHAR(64) DEFAULT '' COMMENT '微信ID',
            `role` CHAR(1)  NOT NULL COMMENT '1买家2卖家' ,
    create_time DATE  ,
    update_time TIMESTAMP*/

    private  Long userId;

    private String username;

    private String password;

    private String openId;

    private String role;
}
