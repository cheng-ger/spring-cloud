package com.cyl.it.product.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class ProductInfoDto extends  BaseDto{

    /*`product_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品主键',
    `product_name_cn` VARCHAR (128) NOT NULL COMMENT '商品中文名称',
    `product_name_en` VARCHAR (128) NOT NULL COMMENT '商品英文名称',
    `product_price` DECIMAL (8, 2) NOT NULL COMMENT '商品单价',
    `product_stock` INT NOT NULL COMMENT '库存',
    `product_desc` VARCHAR (512) COMMENT '商品描述',
    `product_icon` VARCHAR (512)  COMMENT '商品英文名称',
    `status` CHAR(1)  DEFAULT '1' COMMENT '商品状态0 : 失效  1 : 有效',
    `category_id` VARCHAR (128) NOT NULL COMMENT '类目类型',*/

    private  Long productId;

    private String productNameCn;

    private String productNameEn;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDes;

    private String productIcon;

    private String status;

    private Long categoryId;

}
