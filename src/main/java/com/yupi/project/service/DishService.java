package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.Dish;
import org.springframework.stereotype.Service;

/**
 * @author nyf
 * @description 针对表【dish（菜品）】的数据库操作Service
 */
@Service
public interface DishService extends IService<Dish> {

}
