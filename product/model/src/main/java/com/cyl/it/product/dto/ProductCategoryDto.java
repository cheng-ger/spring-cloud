package com.cyl.it.product.dto;

import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class ProductCategoryDto extends  BaseDto {

    /*`category_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '类目主键',
    `category_name_cn` VARCHAR (128) NOT NULL COMMENT '类目中文名称',
    `category_name_en` VARCHAR (128) NOT NULL COMMENT '类目英文名称',
    `category_type` VARCHAR (128) UNIQUE NOT NULL  COMMENT '类目类型',
    `status`  CHAR(1)  DEFAULT '1'     COMMENT '商品类目状态  1：有效 ',*/


    private Long categoryId;

    private String categoryNameCn;

    private String categoryNameEn;

   /* private String categoryType;*/

    private String status;

}
