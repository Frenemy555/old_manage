package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {
    // 新增预约
    int insert(Reservation reservation);
    // 修改预约信息
    int updateById(Reservation reservation);
    // 根据id删除预约（逻辑删除）
    int deleteById(Long id);
    // 根据id查询预约
    Reservation selectById(Long id);
    // 查询所有预约（含关联信息）
    List<Reservation> selectAll();
    // 修改预约状态（确认/取消）
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
