package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Elderly;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElderlyMapper {
    // 新增老人档案
    int insert(Elderly elderly);
    // 修改老人档案
    int updateById(Elderly elderly);
    // 根据id删除老人档案（逻辑删除）
    int deleteById(Long id);
    // 根据id查询老人档案
    Elderly selectById(Long id);
    // 查询所有老人档案
    List<Elderly> selectAll();
    // 根据姓名模糊查询老人档案
    List<Elderly> selectByName(String name);
}
