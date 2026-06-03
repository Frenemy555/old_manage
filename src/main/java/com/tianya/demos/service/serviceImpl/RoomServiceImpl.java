package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.RoomMapper;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.Room;
import com.tianya.demos.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    // 新增房间：将房间信息插入数据库
    @Override
    public Result<String> add(Room room) {
        roomMapper.insert(room);
        return Result.success("添加成功");
    }

    // 修改房间信息：根据id更新房间数据
    @Override
    public Result<String> update(Room room) {
        roomMapper.updateById(room);
        return Result.success("修改成功");
    }

    // 删除房间：根据id逻辑删除房间
    @Override
    public Result<String> delete(Long id) {
        roomMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询房间：返回房间详情
    @Override
    public Result<Room> getById(Long id) {
        Room room = roomMapper.selectById(id);
        if(room == null){
            return Result.error("房间不存在");
        }
        return Result.success(room);
    }

    // 查询所有房间：返回房间列表（含楼栋名称）
    @Override
    public Result<List<Room>> list() {
        return Result.success(roomMapper.selectAll());
    }

    // 根据楼栋id查询房间：返回该楼栋下的所有房间
    @Override
    public Result<List<Room>> listByBuildingId(Long buildingId) {
        return Result.success(roomMapper.selectByBuildingId(buildingId));
    }
}
