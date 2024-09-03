package com.yupi.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品
 *
 * @TableName dish
 */
@TableName(value = "dish")
@Data
public class Dish implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long dishId;

    private Long homeId;

    /**
     * 菜品昵称
     */
    private String dishName;

    private Integer price;

    /**
     * 菜品分类
     */
    private String category;

    /**
     * 菜品介绍
     */
    private String dishText;

    /**
     * 菜品图片
     */
    private String dishPhoto;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}