package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.CheckIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckInMapper {
    // 新增入住申请
    int insert(CheckIn checkIn);
    // 修改入住申请
    int updateById(CheckIn checkIn);
    // 根据id删除入住申请（逻辑删除）
    int deleteById(Long id);
    // 根据id查询入住申请
    CheckIn selectById(Long id);
    // 查询所有入住申请（含关联信息）
    List<CheckIn> selectAll();
    // 修改入住申请状态（审批通过/驳回）
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
