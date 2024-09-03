package com.yupi.project.model.dto.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取一个家的菜品请求
 *
 * @author nyf
 */
@Data
public class DishQueryRequest implements Serializable {

    /**
     * 家的id
     */
    private Integer homeId;

    private static final long serialVersionUID = 1L;
}