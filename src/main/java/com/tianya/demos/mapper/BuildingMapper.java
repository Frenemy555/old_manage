package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Building;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuildingMapper {
    // 新增楼栋
    int insert(Building building);
    // 修改楼栋信息
    int updateById(Building building);
    // 根据id删除楼栋（逻辑删除）
    int deleteById(Long id);
    // 根据id查询楼栋
    Building selectById(Long id);
    // 查询所有楼栋
    List<Building> selectAll();
}
