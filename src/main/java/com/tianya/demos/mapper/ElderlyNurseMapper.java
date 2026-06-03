package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.ElderlyNurse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElderlyNurseMapper {
    // 新增护理记录
    int insert(ElderlyNurse elderlyNurse);
    // 修改护理记录
    int updateById(ElderlyNurse elderlyNurse);
    // 根据id删除护理记录（逻辑删除）
    int deleteById(Long id);
    // 根据id查询护理记录
    ElderlyNurse selectById(Long id);
    // 查询所有护理记录（含关联信息）
    List<ElderlyNurse> selectAll();
    // 根据老人id查询护理记录
    List<ElderlyNurse> selectByElderlyId(Long elderlyId);
}
