package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Bed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BedMapper {
    // 新增床位
    int insert(Bed bed);
    // 修改床位信息
    int updateById(Bed bed);
    // 根据id删除床位（逻辑删除）
    int deleteById(Long id);
    // 根据id查询床位
    Bed selectById(Long id);
    // 查询所有床位
    List<Bed> selectAll();
    // 根据房间id查询床位
    List<Bed> selectByRoomId(Long roomId);
    // 修改床位状态
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
