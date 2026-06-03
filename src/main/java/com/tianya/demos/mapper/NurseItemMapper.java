package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.NurseItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NurseItemMapper {
    // 新增护理项目
    int insert(NurseItem nurseItem);
    // 修改护理项目
    int updateById(NurseItem nurseItem);
    // 根据id删除护理项目（逻辑删除）
    int deleteById(Long id);
    // 根据id查询护理项目
    NurseItem selectById(Long id);
    // 查询所有护理项目
    List<NurseItem> selectAll();
}
