package com.yupi.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author yupi
 */
@Data
public class DeleteDishRequest implements Serializable {
    /**
     * 菜品id
     */
    private Long dishId;

    /**
     * 家的id
     */
    private Long homeId;

    private static final long serialVersionUID = 1L;
}