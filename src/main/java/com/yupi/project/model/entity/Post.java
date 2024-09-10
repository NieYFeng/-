package com.yupi.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子
 *
 * @TableName post
 */
@TableName(value = "post")
@Data
public class Post implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long postId;

    /**
     * 内容
     */
    private String content;

    /**
     * 照片地址
     */
    private String photo;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}