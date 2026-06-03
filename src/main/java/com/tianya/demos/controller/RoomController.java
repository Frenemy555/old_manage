package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.Room;
import com.tianya.demos.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 新增房间
    @PostMapping
    public Result<String> add(@RequestBody Room room){
        return roomService.add(room);
    }

    // 修改房间信息
    @PutMapping
    public Result<String> update(@RequestBody Room room){
        return roomService.update(room);
    }

    // 删除房间
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return roomService.delete(id);
    }

    // 根据id查询房间详情
    @GetMapping("/{id}")
    public Result<Room> info(@PathVariable Long id){
        return roomService.getById(id);
    }

    // 查询所有房间列表，或根据楼栋id筛选
    @GetMapping
    public Result<List<Room>> list(@RequestParam(required = false) Long buildingId){
        if(buildingId != null){
            return roomService.listByBuildingId(buildingId);
        }
        return roomService.list();
    }
}
