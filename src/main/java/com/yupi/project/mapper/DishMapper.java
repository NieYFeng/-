package com.yupi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.project.model.entity.Dish;
import com.yupi.project.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.yupi.project.model.domain.User
 */
public interface DishMapper extends BaseMapper<Dish> {
    /**
     * 根据 dish_id 和 chef_id 删除记录
     *
     * @param dishId 菜品ID
     * @param homeId 厨师ID
     * @return 删除的记录数
     */
    boolean deleteDish(@Param("dishId") Long dishId, @Param("homeId") Long homeId);
}




