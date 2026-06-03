package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.Room;

import java.util.List;

public interface RoomService {
    // 新增房间
    Result<String> add(Room room);
    // 修改房间信息
    Result<String> update(Room room);
    // 删除房间
    Result<String> delete(Long id);
    // 根据id查询房间
    Result<Room> getById(Long id);
    // 查询所有房间
    Result<List<Room>> list();
    // 根据楼栋id查询房间
    Result<List<Room>> listByBuildingId(Long buildingId);
}
