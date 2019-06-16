package com.cyl.it.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 360847440523157094L;

    /*`create_by`  VARCHAR(128) NOT NULL  DEFAULT '-1' COMMENT '创建人工号',
    `create_time` DATE NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `last_update_by` VARCHAR (128) NOT NULL DEFAULT '-1' COMMENT '最近更新人',*/

    private String createBy;

    private Date createTime;

    private Date updateTime;

    private String lastUpdateBy;


}
