package com.yupi.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.DeleteRequest;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.dto.menu.DeleteDishRequest;
import com.yupi.project.model.dto.menu.DishQueryRequest;
import com.yupi.project.model.dto.menu.DishUpdateRequest;
import com.yupi.project.model.dto.menu.MenuAddRequest;
import com.yupi.project.model.dto.user.*;
import com.yupi.project.model.entity.Dish;
import com.yupi.project.model.entity.User;
import com.yupi.project.model.vo.DishVO;
import com.yupi.project.model.vo.UserVO;
import com.yupi.project.service.DishService;
import com.yupi.project.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单接口
 *
 * @author nyf
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private DishService dishService;

    /**
     * 创建菜品
     *
     * @param menuAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> adddish(@RequestBody MenuAddRequest menuAddRequest, HttpServletRequest request) {
        if (menuAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Dish dish = new Dish();
        BeanUtils.copyProperties(menuAddRequest, dish);
        boolean result = dishService.save(dish);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(dish.getDishId());
    }

    /**
     * 删除菜品
     *
     * @param deleteDishRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteDish(@RequestBody DeleteDishRequest deleteDishRequest, HttpServletRequest request) {
        if (deleteDishRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = dishService.removeById(deleteDishRequest.getDishId());
        if (!b) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(b);
    }

    /**
     * 更新用户
     *
     * @param dishUpdateRequest
     * @param request
     * @return
     */
    @PostMapping("/update")
    public BaseResponse<Boolean> updateDish(@RequestBody DishUpdateRequest dishUpdateRequest, HttpServletRequest request) {
        if (dishUpdateRequest == null || dishUpdateRequest.getDishId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishUpdateRequest, dish);
        boolean result = dishService.updateById(dish);
        if(!result){
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(result);
    }


    /**
     * 获取用户列表
     *
     * @param dishQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<DishVO>> listDish(@RequestBody DishQueryRequest dishQueryRequest, HttpServletRequest request) {
        Dish dishQuery = new Dish();
        if (dishQueryRequest != null) {
            BeanUtils.copyProperties(dishQueryRequest, dishQuery);
        }
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>(dishQuery);
        List<Dish> dishList = dishService.list(queryWrapper);
        List<DishVO> dishVOList = dishList.stream().map(dish -> {
            DishVO dishVO = new DishVO();
            BeanUtils.copyProperties(dish, dishVO);
            return dishVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(dishVOList);
    }

    // endregion
}
