package com.yupi.project.model.dto.post;

import com.yupi.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author yupi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostQueryRequest extends PageRequest implements Serializable {

    /**
     * 内容（个人介绍），支持模糊查询
     */
    private String content;

    /**
     * 状态（0-待审核, 1-通过, 2-拒绝）
     */
    private Integer reviewStatus;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 用于光标分页
     */
    private Long lastId;

    private Long pageSize;

    private static final long serialVersionUID = 1L;
}