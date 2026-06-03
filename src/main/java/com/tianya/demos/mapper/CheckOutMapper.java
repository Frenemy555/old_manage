package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.CheckOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckOutMapper {
    // 新增退住申请
    int insert(CheckOut checkOut);
    // 修改退住申请
    int updateById(CheckOut checkOut);
    // 根据id删除退住申请（逻辑删除）
    int deleteById(Long id);
    // 根据id查询退住申请
    CheckOut selectById(Long id);
    // 查询所有退住申请（含关联信息）
    List<CheckOut> selectAll();
    // 修改退住申请状态（审批通过/驳回）
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
