package com.yupi.project.model.dto.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author nyf
 */
@Data
public class DeleteDishRequest implements Serializable {
    /**
     * 菜品id
     */
    private Long dishId;

    private static final long serialVersionUID = 1L;
}