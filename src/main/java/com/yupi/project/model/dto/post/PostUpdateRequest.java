package com.yupi.project.model.dto.post;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @TableName product
 */
@Data
public class PostUpdateRequest implements Serializable {

    /**
     * id
     */
    private long postId;

    /**
     * 内容
     */
    private String content;

    /**
     * 照片地址
     */
    private String photo;

    /**
     * 状态（0-待审核, 1-通过, 2-拒绝）
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    private static final long serialVersionUID = 1L;
}