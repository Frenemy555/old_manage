package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    // 新增房间
    int insert(Room room);
    // 修改房间信息
    int updateById(Room room);
    // 根据id删除房间（逻辑删除）
    int deleteById(Long id);
    // 根据id查询房间
    Room selectById(Long id);
    // 根据id查询房间（带楼栋名称）
    Room selectByIdWithBuilding(Long id);
    // 查询所有房间
    List<Room> selectAll();
    // 根据楼栋id查询房间
    List<Room> selectByBuildingId(Long buildingId);
}
