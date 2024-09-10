package com.yupi.project.model.dto.post;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class PostAddRequest implements Serializable {

    private Long userId;
    /**
     * 内容（个人介绍）
     */
    private String content;

    /**
     * 照片地址
     */
    private String photo;

    private static final long serialVersionUID = 1L;
}