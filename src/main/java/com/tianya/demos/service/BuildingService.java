package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Building;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface BuildingService {
    // 新增楼栋
    Result<String> add(Building building);
    // 修改楼栋信息
    Result<String> update(Building building);
    // 删除楼栋
    Result<String> delete(Long id);
    // 根据id查询楼栋
    Result<Building> getById(Long id);
    // 查询所有楼栋
    Result<List<Building>> list();
}
