package com.yupi.project.model.vo;

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
public class DishVO implements Serializable {
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

    private Integer Price;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}